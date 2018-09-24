package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Detects signs in an image, draws boxes around them, and writes the results
 * to "signDetection.png".
 */
public class DetectMarkup {

    static String path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data";
    static String name = "a_cut_r.mp4";
    static Mat pos, nol, neg, around;
    static int gc = 0;
    ArrayList<ArrayList<double[]>> arrayList = new ArrayList<>();
    ArrayList<ArrayList<double[]>> buffer = new ArrayList<>();
    Mat res = new Mat();
    Mat hsv;
    Mat posmat = new Mat();
    Mat nolmat = new Mat();
    Mat negmat = new Mat();
    Mat aroundmat = new Mat();
    double[] line;
    double[] average;
    double rho, theta;
    int i, j, k, l;
    Point pt1 = new Point();
    Point pt2 = new Point();
    double a, b;
    double x0, y0;
    long begin, per;
    Scalar color = new Scalar(0, 0, 255);
    boolean wrote = false;
    double[] empty = new double[]{0, 0};


    static {
        pos = Imgcodecs.imread(path + "/lines/incline" + "/pos.tif");
        Imgproc.cvtColor(pos, pos, Imgproc.COLOR_RGB2GRAY);
        pos.convertTo(pos, CvType.CV_16S);
        Core.subtract(pos, new Scalar(128), pos);

        nol = Imgcodecs.imread(path + "/lines/incline" + "/nol.tif");
        Imgproc.cvtColor(nol, nol, Imgproc.COLOR_RGB2GRAY);
        nol.convertTo(nol, CvType.CV_16S);
        Core.subtract(nol, new Scalar(128), nol);

        neg = Imgcodecs.imread(path + "/lines/incline" + "/neg.tif");
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

        hsv = image.submat(300, 600, 640, 1280);
        Imgproc.cvtColor(hsv, hsv, Imgproc.COLOR_RGB2GRAY);
        Imgproc.blur(hsv, hsv, new Size(3,3));
        Imgproc.Canny(hsv, hsv, 30, 60, 3, false);
//        hsv.convertTo(hsv, CvType.CV_16S);

//        Imgproc.filter2D(hsv, posmat, CvType.CV_32F, pos);
//        Imgproc.threshold(posmat, posmat, 100000, 255, CvType.CV_8U);
//        Imgproc.filter2D(hsv, nolmat, CvType.CV_32F, nol);
//        Imgproc.threshold(nolmat, nolmat, 150000, 255, CvType.CV_8U);
//        Imgproc.filter2D(hsv, negmat, CvType.CV_32F, neg);
//        Imgproc.threshold(negmat, negmat, 150000, 255, CvType.CV_8U);

//        Core.add(p60mat, n60mat, hsv);
//        Core.add(p30mat, hsv, hsv);
//        Core.add(p30mat, hsv, hsv);
//        Core.add(p45mat, n45mat, hsv);
//        Core.add(np0mat, hsv, hsv);

//        posmat.copyTo(hsv);
//        hsv.convertTo(hsv, CvType.CV_8U);
//
//        Imgproc.filter2D(hsv, aroundmat, CvType.CV_32F, around);
//        Imgproc.threshold(aroundmat, aroundmat, 70000, 255, CvType.CV_8U);
//
//        aroundmat.copyTo(hsv);
//        hsv.convertTo(hsv, CvType.CV_8U);

        Imgproc.HoughLines(hsv, res, 1, 3.14/180, 12);

//        System.out.println("res = " + res);

//        hsv = Mat.zeros(hsv.size(), CvType.CV_8U);

        arrayList.clear();
        for (k=0; k<res.rows(); k++) {
            line = res.get(k, 0);
            rho = line[0];
            theta = line[1];
            wrote = false;

            for (i=0; i<arrayList.size(); i++) {
                average = arrayList.get(i).get(0);
                if ((Math.sqrt(average[0]*average[0] + rho*rho - 2*average[0]*rho*Math.cos(theta-average[1])) < 70) && ((theta-average[1]) < 0.35)) {

                    arrayList.get(i).add(line);
                    rho = 0;
                    theta = 0;
                    for (j=1; j<arrayList.get(i).size(); j++) {
                        rho += arrayList.get(i).get(j)[0];
                        theta += arrayList.get(i).get(j)[1];
                    }

                    if ((j-1)>1) {
                        arrayList.get(i).get(0)[0] = rho/(j-1);
                        arrayList.get(i).get(0)[1] = theta/(j-1);
                    }

                    wrote = true;
                    break;
                }
            }

            if (wrote==false) {
                ArrayList<double[]> temp = new ArrayList<>();
                temp.add(line);
                temp.add(line);
                arrayList.add(temp);
            }
        }

        int len = 50;
        for (ArrayList<double[]> it: arrayList) {
            if (it.size() >= 8) {
                line = it.get(0);
                rho = line[0];
                theta = line[1];
                wrote = false;

//                a = Math.cos(theta);
//                b = Math.sin(theta);
//                x0 = a * rho;
//                y0 = b * rho;
//
//                pt1.x = Math.round(x0 + 1000 * (-b)) + 640;
//                pt1.y = Math.round(y0 + 1000 * (a)) + 300;
//                pt2.x = Math.round(x0 - 1000 * (-b)) + 640;
//                pt2.y = Math.round(y0 - 1000 * (a)) + 300;
//                Imgproc.line(image, pt1, pt2, color, 1);

                for (i = 0; i < buffer.size(); i++) {
                    average = buffer.get(i).get(0);
                    if ((Math.sqrt(average[0] * average[0] + rho * rho - 2 * average[0] * rho * Math.cos(theta - average[1])) < 40) && ((theta - average[1]) < 0.2)) {
                        buffer.get(i).add(2, line);
                        buffer.get(i).get(1)[0] = buffer.get(i).get(0)[0];
                        buffer.get(i).get(1)[1] = buffer.get(i).get(0)[1];
                        wrote = true;
                        break;
                    }
                }

                if (wrote == false) {
                    ArrayList<double[]> temp = new ArrayList<>();
                    double[] first = new double[]{line[0], line[1], 1};
                    temp.add(first);
                    temp.add(line);
                    temp.add(line);
                    for (i = 0; i < len; i++) temp.add(empty);
                    buffer.add(temp);
                }
            }
        }

        Iterator<ArrayList<double[]>> iter = buffer.iterator();
        while (iter.hasNext()) {
            ArrayList<double[]> it = iter.next();

            if (it.size() <= len+2) it.add(2, empty);
            it.remove(len+2);

            rho = 0;
            theta = 0;
            k = 0;
            l=0;

            for (j=2; j<it.size(); j++) {
                if (it.get(j)[0] != 0) {
                    if (j <= (len/5) || j==13 || j==15 || j==21 || j==27 || j==41 || j==51) {
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


        for (ArrayList<double[]> it: buffer) {
            if (it.get(0)[2] > len*0.1) {
                rho = it.get(0)[0];
                theta = it.get(0)[1];
                a = Math.cos(theta);
                b = Math.sin(theta);
                x0 = a * rho;
                y0 = b * rho;

                pt1.x = Math.round(x0 + 1000 * (-b)) + 640;
                pt1.y = Math.round(y0 + 1000 * (a)) + 300;
                pt2.x = Math.round(x0 - 1000 * (-b)) + 640;
                pt2.y = Math.round(y0 - 1000 * (a)) + 300;
                Imgproc.line(image, pt1, pt2, color, 1);
            }
        }

        ArrayList<Mat> list = new ArrayList<Mat>();
        list.add(Mat.zeros(300, 640, CvType.CV_8U));
        list.add(hsv);
        Core.hconcat(list, hsv);
        list.clear();
        list.add(Mat.zeros(300, 1280, CvType.CV_8U));
        list.add(hsv);
        list.add(Mat.zeros(120, 1280, CvType.CV_8U));
        Core.vconcat(list, hsv);

        Imgproc.cvtColor(hsv, hsv, Imgproc.COLOR_GRAY2RGB);
        hsv.copyTo(image);
    }
}
