package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import java.util.*;

/*
 * Detects signs in an image, draws boxes around them, and writes the results
 * to "signDetection.png".
 */
public class DetectRoad {

    static String path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data";
    static String name = "a1.mp4";
    static Mat pos, nol, neg, around;
    static int gc = 0;
    ArrayList<ArrayList<double[]>> arrayList = new ArrayList<>();
    ArrayList<ArrayList<double[]>> buffer1 = new ArrayList<>();
    ArrayList<ArrayList<double[]>> buffer2 = new ArrayList<>();
    ArrayList<ArrayList<double[]>> buffer = new ArrayList<>();
    Mat res = new Mat();
    Mat hsv;
    Mat posmat = new Mat();
    Mat nolmat = new Mat();
    Mat negmat = new Mat();
    Mat aroundmat = new Mat();
    double[] line;
    double[] average;
    double[] first;
    double rho, theta;
    int i, j, k, l, cnt1 = 0, cnt2 = 15;
    Point pt1 = new Point();
    Point pt2 = new Point();
    double a, b;
    double x0, y0;
    long begin, per;
    Scalar red = new Scalar(0, 0, 255);
    Scalar black = new Scalar(0, 0, 0);
    boolean wrote1 = false;
    boolean wrote2 = false;
    double[] empty = new double[]{0, 0};
    int center = 600;
    int top = 360;
    int bottom = 700;


    static {
        pos = Imgcodecs.imread(path + "/lines/incline" + "/posa.tif");
        Imgproc.cvtColor(pos, pos, Imgproc.COLOR_RGB2GRAY);
        pos.convertTo(pos, CvType.CV_16S);
        Core.subtract(pos, new Scalar(128), pos);

        nol = Imgcodecs.imread(path + "/lines/incline" + "/nol.tif");
        Imgproc.cvtColor(nol, nol, Imgproc.COLOR_RGB2GRAY);
        nol.convertTo(nol, CvType.CV_16S);
        Core.subtract(nol, new Scalar(128), nol);

        neg = Imgcodecs.imread(path + "/lines/incline" + "/nega.tif");
        Imgproc.cvtColor(neg, neg, Imgproc.COLOR_RGB2GRAY);
        neg.convertTo(neg, CvType.CV_16S);
        Core.subtract(neg, new Scalar(128), neg);

        around = Imgcodecs.imread(path + "/lines/incline" + "/around.tif");
        Imgproc.cvtColor(around, around, Imgproc.COLOR_RGB2GRAY);
        around.convertTo(around, CvType.CV_16S);
    }

    public void run() {
        System.out.println("Running DetectRoad");

        begin = System.nanoTime();
        per = begin;

        VideoCapture videoCapture = new VideoCapture(path + "/" + name);
        Mat frame = new Mat();
        VideoWriter videoWriter = new VideoWriter(path + "/_" + name,VideoWriter.fourcc('X','V','I','D'),25,new Size(1280,720));

        while (videoCapture.read(frame)) {
//        videoCapture.read(frame);
            System.out.println("" + (System.nanoTime()-per));
            per = System.nanoTime();
            findLinesConvolution(frame);
            videoWriter.write(frame);
            gc++;
            if (gc>100) System.gc();
        }
        System.out.println("Stop");
        videoWriter.release();
        System.out.println("end " + (System.nanoTime()-begin));
    }

    public void findLinesConvolution (Mat image) {
//        System.out.println("find Lines");
        cnt1++;
        cnt2++;
        if (cnt1 > 30) {
            cnt1 = 0;
            buffer1.clear();
        }
        if (cnt2 > 30) {
            cnt2 = 0;
            buffer2.clear();
        }

        hsv = image.submat(top, bottom, center, 1280);
        Imgproc.cvtColor(hsv, hsv, Imgproc.COLOR_RGB2GRAY);
        Imgproc.blur(hsv, hsv, new Size(3,3));
        Imgproc.Canny(hsv, hsv, 30, 60, 3, false);
//        hsv.convertTo(hsv, CvType.CV_16S);

        Imgproc.filter2D(hsv, posmat, CvType.CV_32F, pos);
        Imgproc.threshold(posmat, posmat, 180000, 255, CvType.CV_8U);
//        Imgproc.filter2D(hsv, nolmat, CvType.CV_32F, nol);
//        Imgproc.threshold(nolmat, nolmat, 150000, 255, CvType.CV_8U);
//        Imgproc.filter2D(hsv, negmat, CvType.CV_32F, neg);
//        Imgproc.threshold(negmat, negmat, 150000, 255, CvType.CV_8U);

//        Core.add(p60mat, n60mat, hsv);
//        Core.add(p30mat, hsv, hsv);
//        Core.add(p30mat, hsv, hsv);
//        Core.add(p45mat, n45mat, hsv);
//        Core.add(np0mat, hsv, hsv);

        posmat.copyTo(hsv);
        hsv.convertTo(hsv, CvType.CV_8U);

        Imgproc.filter2D(hsv, aroundmat, CvType.CV_32F, around);
        Imgproc.threshold(aroundmat, aroundmat, 71000, 255, CvType.CV_8U);
//
        aroundmat.copyTo(hsv);
        hsv.convertTo(hsv, CvType.CV_8U);
//
        Imgproc.HoughLines(hsv, res, 1, 3.14/180, 12);

//        System.out.println("res = " + res);

        hsv = Mat.zeros(hsv.size(), CvType.CV_8U);

        arrayList.clear();

        for (k=0; k<res.rows(); k++) {
            line = res.get(k, 0);
            rho = line[0];
            theta = line[1];
            wrote1 = false;

//            a = Math.cos(theta);
//            b = Math.sin(theta);
//            x0 = a * rho;
//            y0 = b * rho;
//
//            pt1.x = Math.round(x0 + 1000 * (-b)) + center;
//            pt1.y = Math.round(y0 + 1000 * (a)) + top;
//            pt2.x = Math.round(x0 - 1000 * (-b)) + center;
//            pt2.y = Math.round(y0 - 1000 * (a)) + top;
//            Imgproc.line(image, pt1, pt2, red, 1);
//            Imgcodecs.imwrite(path + "/_a_cut_r.jpg", image);

            double a2 = (-1)/Math.tan(theta);
            double b2 = rho/Math.sin(theta);

            for (i=0; i<arrayList.size(); i++) {
                average = arrayList.get(i).get(0);
                first = arrayList.get(i).get(1);

                if ( average[2] == 0 && average[3] == 0) {
                    double angle = Math.abs(theta - first[1]);
                    if (angle > 0 && angle < 0.7) {
                        arrayList.get(i).add(line);

                        double a1 = (-1) / Math.tan(first[1]);
                        double b1 = first[0] / Math.sin(first[1]);
                        average[0] = (first[0] + rho) / 2;
                        average[1] = (first[1] + theta) / 2;
                        average[2] = (b1 - b2) / (a2 - a1);
                        average[3] = b1 + a1 * (b1 - b2) / (a2 - a1);
                        wrote1 = true;
                        break;
                    }
                } else {
                    if (((Math.abs(a2*average[2] - average[3] + b2)/Math.sqrt(a2*a2 + 1)) < 50) && (Math.abs(theta - average[1]) < 0.35)) {
                        arrayList.get(i).add(line);
                        rho = 0;
                        theta = 0;
                        for (j = 1; j < arrayList.get(i).size(); j++) {
                            rho += arrayList.get(i).get(j)[0];
                            theta += arrayList.get(i).get(j)[1];
                        }

                        if ((j - 1) > 1) {
                            average[0] = rho / (j - 1);
                            average[1] = theta / (j - 1);
                        }

                        wrote1 = true;
                        break;
                    }
                }
            }

            if (wrote1==false) {
                ArrayList<double[]> temp = new ArrayList<>();
                average = new double[]{line[0], line[1], 0, 0};
                temp.add(average);
                temp.add(line);
                arrayList.add(temp);
            }
        }
//        System.out.println("arrayList size = " + arrayList.size());
//        for (ArrayList<double[]> it: arrayList) {
//            System.out.println("arrayList cell size = " + it.size());
//            System.out.println("arrayList cell = " + it.get(0)[0] + "; " + it.get(0)[1] + "; " + it.get(0)[2] + "; " + it.get(0)[3] + ";");
//        }

        int len = 20;
        for (ArrayList<double[]> it: arrayList) {
            if (it.size() >= 10) {
                line = it.get(0);
                rho = line[0];
                theta = line[1];
                wrote1 = false;
                wrote2 = false;

//                a = Math.cos(theta);
//                b = Math.sin(theta);
//                x0 = a * rho;
//                y0 = b * rho;
//
//                pt1.x = Math.round(x0 + 1000 * (-b)) + center;
//                pt1.y = Math.round(y0 + 1000 * (a)) + top;
//                pt2.x = Math.round(x0 - 1000 * (-b)) + center;
//                pt2.y = Math.round(y0 - 1000 * (a)) + top;
//                j++;
//                Imgproc.line(image, pt1, pt2, new Scalar(j*50, 255 - j*50, 0), 1);
//                Imgproc.circle(image, new Point(line[2]+center,line[3]+top), 20, new Scalar(j*50, 255 - j*50, 0), 2);
//                Imgcodecs.imwrite(path + "/_a_cut_r.jpg", image);

                for (i = 0; i < buffer1.size(); i++) {
                    average = buffer1.get(i).get(0);
                    if ((Math.sqrt(average[0] * average[0] + rho * rho - 2 * average[0] * rho * Math.cos(theta - average[1])) < 20) && (Math.abs(theta - average[1]) < 0.2)) {
                        buffer1.get(i).add(2, line);
                        buffer1.get(i).get(1)[0] = buffer1.get(i).get(0)[0];
                        buffer1.get(i).get(1)[1] = buffer1.get(i).get(0)[1];
                        wrote1 = true;
                        break;
                    }
                }

                if (wrote1 == false) {
                    ArrayList<double[]> temp = new ArrayList<>();
                    double[] first = new double[]{line[0], line[1], 1};
                    temp.add(first);
                    temp.add(line);
                    temp.add(line);
                    for (i = 0; i < len; i++) temp.add(empty);
                    buffer1.add(temp);
                }

                for (i = 0; i < buffer2.size(); i++) {
                    average = buffer2.get(i).get(0);
                    if ((Math.sqrt(average[0] * average[0] + rho * rho - 2 * average[0] * rho * Math.cos(theta - average[1])) < 20) && (Math.abs(theta - average[1]) < 0.2)) {
                        buffer2.get(i).add(2, line);
                        buffer2.get(i).get(1)[0] = buffer2.get(i).get(0)[0];
                        buffer2.get(i).get(1)[1] = buffer2.get(i).get(0)[1];
                        wrote2 = true;
                        break;
                    }
                }

                if (wrote2 == false) {
                    ArrayList<double[]> temp = new ArrayList<>();
                    double[] first = new double[]{line[0], line[1], 1};
                    temp.add(first);
                    temp.add(line);
                    temp.add(line);
                    for (i = 0; i < len; i++) temp.add(empty);
                    buffer2.add(temp);
                }
            }
        }

        Iterator<ArrayList<double[]>> iter = buffer1.iterator();
        while (iter.hasNext()) {
            ArrayList<double[]> it = iter.next();

            if (it.size() <= len+2) it.add(2, empty);
            it.remove(len+2);

            rho = 0;
            theta = 0;
            k = 0;
            l = 0;
            for (j=2; j<it.size(); j++) {
                if (it.get(j)[0] != 0) {
                    if (j<it.size()/2+1) {
                        rho += it.get(j)[0];
                        theta += it.get(j)[1];
                        k++;
                    }
                    l++;
                }

            }

            if (k > 0) {
                rho = rho/k;
                theta = theta/k;
//                if ((Math.sqrt(it.get(1)[0]*it.get(1)[0] + rho*rho - 2*it.get(1)[0]*rho*Math.cos(theta-it.get(1)[1])) < 2) && ((theta-it.get(1)[1]) < 0.01)) {
                    it.get(0)[0] = rho;
                    it.get(0)[1] = theta;
                    it.get(0)[2] = l;
//                } else {
//                    it.get(2)[0] = 0;
//                    it.get(2)[1] = 0;
//                }
            } else {
                iter.remove();
            }
        }

        iter = buffer2.iterator();
        while (iter.hasNext()) {
            ArrayList<double[]> it = iter.next();

            if (it.size() <= len+2) it.add(2, empty);
            it.remove(len+2);

            rho = 0;
            theta = 0;
            k = 0;
            l = 0;
            for (j=2; j<it.size(); j++) {
                if (it.get(j)[0] != 0) {
                    if (j < it.size() / 2 + 1) {
                        rho += it.get(j)[0];
                        theta += it.get(j)[1];
                        k++;
                    }
                    l++;
                }
            }

            if (k > 0) {
                rho = rho/k;
                theta = theta/k;
//                if ((Math.sqrt(it.get(1)[0]*it.get(1)[0] + rho*rho - 2*it.get(1)[0]*rho*Math.cos(theta-it.get(1)[1])) < 2) && ((theta-it.get(1)[1]) < 0.01)) {
                it.get(0)[0] = rho;
                it.get(0)[1] = theta;
                it.get(0)[2] = l;
//                } else {
//                    it.get(2)[0] = 0;
//                    it.get(2)[1] = 0;
//                }
            } else {
                iter.remove();
            }
        }

        buffer.clear();
        for (ArrayList<double[]> it: buffer1) {
            if (it.get(0)[2] > len*0.8) {
                buffer.add(it);
            }
        }

        for (ArrayList<double[]> it: buffer2) {
            if (it.get(0)[2] > len*0.8) {
                buffer.add(it);
            }
        }

//        arrayList.clear();
//        iter = buffer.iterator();
//        while (iter.hasNext()) {
//            ArrayList<double[]> it = iter.next();
//
//            arrayList.add(it);
//            iter.remove();
//
//            Iterator<ArrayList<double[]>> iter1 = buffer.iterator();
//            while (iter1.hasNext()) {
//                ArrayList<double[]> it1 = iter1.next();
//
//                double rho1 = arrayList.get(arrayList.size()-1).get(0)[0];
//                double theta1 = arrayList.get(arrayList.size()-1).get(0)[1];
//                double rho2 = it1.get(0)[0];
//                double theta2 = it1.get(0)[1];
//                if ((Math.abs(rho2 - rho1) < 20) && (Math.abs(theta2 - theta1) < 0.2)) {
//                    arrayList.get(arrayList.size()-1).get(0)[0] = (rho1+rho2)/2;
//                    arrayList.get(arrayList.size()-1).get(0)[1] = (theta1+theta2)/2;
//                    iter1.remove();
//                    break;
//                }
//            }
//        }


        for (ArrayList<double[]> it: buffer) {

            rho = it.get(0)[0];
            theta = it.get(0)[1];

            a = Math.cos(theta);
            b = Math.sin(theta);
            x0 = a * rho;
            y0 = b * rho;

            pt1.x = Math.round(x0 + 1000 * (-b)) + center;
            pt1.y = Math.round(y0 + 1000 * (a)) + top;
            pt2.x = Math.round(x0 - 1000 * (-b)) + center;
            pt2.y = Math.round(y0 - 1000 * (a)) + top;
            Imgproc.line(image, pt1, pt2, red, 1);
        }


//        ArrayList<Mat> list = new ArrayList<Mat>();
//        list.add(Mat.zeros(bottom-top, center, CvType.CV_8U));
//        list.add(hsv);
//        Core.hconcat(list, hsv);
//        list.clear();
//        list.add(Mat.zeros(top, 1280, CvType.CV_8U));
//        list.add(hsv);
//        list.add(Mat.zeros(720-bottom, 1280, CvType.CV_8U));
//        Core.vconcat(list, hsv);
//
//        Imgproc.cvtColor(hsv, hsv, Imgproc.COLOR_GRAY2RGB);
//        hsv.copyTo(image);
    }
}
