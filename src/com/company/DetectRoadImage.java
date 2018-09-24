package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Vector;

/*
 * Detects signs in an image, draws boxes around them, and writes the results
 * to "signDetection.png".
 */
public class DetectRoadImage {

    public void run() {
        System.out.println("Running DetectRoad");

        String path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data";
        String name = "6.jpg";
        System.out.println("" + System.nanoTime());

//        Mat n60 = Imgcodecs.imread(path + "/n60.tif");
//        Imgproc.cvtColor(n60, n60, Imgproc.COLOR_RGB2GRAY);
//        n60.convertTo(n60, CvType.CV_16S);
//        Core.subtract(n60, new Scalar(128), n60);
//
//        Mat n45 = Imgcodecs.imread(path + "/n45.tif");
//        Imgproc.cvtColor(n45, n45, Imgproc.COLOR_RGB2GRAY);
//        n45.convertTo(n45, CvType.CV_16S);
//        Core.subtract(n45, new Scalar(128), n45);
//
//        Mat n30 = Imgcodecs.imread(path + "/n30.tif");
//        Imgproc.cvtColor(n30, n30, Imgproc.COLOR_RGB2GRAY);
//        n30.convertTo(n30, CvType.CV_16S);
//        Core.subtract(n30, new Scalar(128), n30);
//
//        Mat n15 = Imgcodecs.imread(path + "/n15.tif");
//        Imgproc.cvtColor(n15, n15, Imgproc.COLOR_RGB2GRAY);
//        n15.convertTo(n15, CvType.CV_16S);
//        Core.subtract(n15, new Scalar(128), n15);
//
//        Mat np0 = Imgcodecs.imread(path + "/np0.tif");
//        Imgproc.cvtColor(np0, np0, Imgproc.COLOR_RGB2GRAY);
//        np0.convertTo(np0, CvType.CV_16S);
//        Core.subtract(np0, new Scalar(128), np0);
//
//        Mat p15 = Imgcodecs.imread(path + "/p15.tif");
//        Imgproc.cvtColor(p15, p15, Imgproc.COLOR_RGB2GRAY);
//        p15.convertTo(p15, CvType.CV_16S);
//        Core.subtract(p15, new Scalar(128), p15);
//
//        Mat p30 = Imgcodecs.imread(path + "/p30.tif");
//        Imgproc.cvtColor(p30, p30, Imgproc.COLOR_RGB2GRAY);
//        p30.convertTo(p30, CvType.CV_16S);
//        Core.subtract(p30, new Scalar(128), p30);
//
//        Mat p45 = Imgcodecs.imread(path + "/p45.tif");
//        Imgproc.cvtColor(p45, p45, Imgproc.COLOR_RGB2GRAY);
//        p45.convertTo(p45, CvType.CV_16S);
//        Core.subtract(p45, new Scalar(128), p45);
//
//        Mat p60 = Imgcodecs.imread(path + "/p60.tif");
//        Imgproc.cvtColor(p60, p60, Imgproc.COLOR_RGB2GRAY);
//        p60.convertTo(p60, CvType.CV_16S);
//        Core.subtract(p60, new Scalar(128), p60);

        System.out.println("Processing " + name);

        Mat image = Imgcodecs.imread(path + "/lines/n15.tif");
        Mat hsv = new Mat();
        Imgproc.cvtColor(image, hsv, Imgproc.COLOR_RGB2GRAY);
//        Imgproc.blur(hsv, hsv, new Size(3,3));
//        Imgproc.Canny(hsv, hsv, 30, 60, 3, false);
//        hsv.convertTo(hsv, CvType.CV_16S);
//
        Mat res = new Mat();
        Imgproc.HoughLines(hsv, res, 0.1, 0.1*3.14/180, 10);

        System.out.println("res = " + res);
//
//        hsv = Mat.zeros(hsv.size(), CvType.CV_8U);
        double[] data;
        double rho = 0, theta = 0;
        int i;
//
        for (i = 0; i < res.rows(); i++) {
            data = res.get(i, 0);
            rho += data[0];
            theta += data[1];
            System.out.println("rho = " + rho + ", theta = " + theta);
        }

        if (res.rows() > 0) {
            rho = rho/i;
            theta = theta/i;
            Point pt1 = new Point();
            Point pt2 = new Point();
            double a, b;
            double x0, y0;
            a = Math.cos(theta);
            b = Math.sin(theta);
            x0 = a * rho;
            y0 = b * rho;

            pt1.x = Math.round(x0 + 1000 * (-b));
            pt1.y = Math.round(y0 + 1000 * (a));
            pt2.x = Math.round(x0 - 1000 * (-b));
            pt2.y = Math.round(y0 - 1000 * (a));
            Imgproc.line(image, pt1, pt2, new Scalar(0, 0, 255), 1);
        }

        Imgcodecs.imwrite(path + "/_n15.tif", image);

//        hsv = hsv.submat(new Rect(802, 554, 10, 5));
//
//        System.out.println(p60.get(0,0)[0] + " " + p60.get(0,1)[0] + " " + p60.get(0,2)[0] + " " + p60.get(0,3)[0] + " " + p60.get(0,4)[0] + " " + p60.get(0,5)[0] + " " + p60.get(0,6)[0] + " " + p60.get(0,7)[0] + " " + p60.get(0,8)[0]);
//        System.out.println(p60.get(1,0)[0] + " " + p60.get(1,1)[0] + " " + p60.get(1,2)[0] + " " + p60.get(1,3)[0] + " " + p60.get(1,4)[0] + " " + p60.get(1,5)[0] + " " + p60.get(1,6)[0] + " " + p60.get(1,7)[0] + " " + p60.get(1,8)[0]);
//        System.out.println(p60.get(2,0)[0] + " " + p60.get(2,1)[0] + " " + p60.get(2,2)[0] + " " + p60.get(2,3)[0] + " " + p60.get(2,4)[0] + " " + p60.get(2,5)[0] + " " + p60.get(2,6)[0] + " " + p60.get(2,7)[0] + " " + p60.get(2,8)[0]);
//        System.out.println(p60.get(3,0)[0] + " " + p60.get(3,1)[0] + " " + p60.get(3,2)[0] + " " + p60.get(3,3)[0] + " " + p60.get(3,4)[0] + " " + p60.get(3,5)[0] + " " + p60.get(3,6)[0] + " " + p60.get(3,7)[0] + " " + p60.get(3,8)[0]);
//        System.out.println(p60.get(4,0)[0] + " " + p60.get(4,1)[0] + " " + p60.get(4,2)[0] + " " + p60.get(4,3)[0] + " " + p60.get(4,4)[0] + " " + p60.get(4,5)[0] + " " + p60.get(4,6)[0] + " " + p60.get(4,7)[0] + " " + p60.get(4,8)[0]);
//        System.out.println();
//
//        System.out.println(hsv.get(0,0)[0] + " " + hsv.get(0,1)[0] + " " + hsv.get(0,2)[0] + " " + hsv.get(0,3)[0] + " " + hsv.get(0,4)[0] + " " + hsv.get(0,5)[0] + " " + hsv.get(0,6)[0] + " " + hsv.get(0,7)[0] + " " + hsv.get(0,8)[0]);
//        System.out.println(hsv.get(1,0)[0] + " " + hsv.get(1,1)[0] + " " + hsv.get(1,2)[0] + " " + hsv.get(1,3)[0] + " " + hsv.get(1,4)[0] + " " + hsv.get(1,5)[0] + " " + hsv.get(1,6)[0] + " " + hsv.get(1,7)[0] + " " + hsv.get(1,8)[0]);
//        System.out.println(hsv.get(2,0)[0] + " " + hsv.get(2,1)[0] + " " + hsv.get(2,2)[0] + " " + hsv.get(2,3)[0] + " " + hsv.get(2,4)[0] + " " + hsv.get(2,5)[0] + " " + hsv.get(2,6)[0] + " " + hsv.get(2,7)[0] + " " + hsv.get(2,8)[0]);
//        System.out.println(hsv.get(3,0)[0] + " " + hsv.get(3,1)[0] + " " + hsv.get(3,2)[0] + " " + hsv.get(3,3)[0] + " " + hsv.get(3,4)[0] + " " + hsv.get(3,5)[0] + " " + hsv.get(3,6)[0] + " " + hsv.get(3,7)[0] + " " + hsv.get(3,8)[0]);
//        System.out.println(hsv.get(4,0)[0] + " " + hsv.get(4,1)[0] + " " + hsv.get(4,2)[0] + " " + hsv.get(4,3)[0] + " " + hsv.get(4,4)[0] + " " + hsv.get(4,5)[0] + " " + hsv.get(4,6)[0] + " " + hsv.get(4,7)[0] + " " + hsv.get(4,8)[0]);
//        System.out.println();
//
//        Mat con = new Mat();
//        Imgproc.filter2D(hsv, con, CvType.CV_32F, p60);
//
//        System.out.println(con.get(0,0)[0] + " " + con.get(0,1)[0] + " " + con.get(0,2)[0] + " " + con.get(0,3)[0] + " " + con.get(0,4)[0] + " " + con.get(0,5)[0] + " " + con.get(0,6)[0] + " " + con.get(0,7)[0] + " " + con.get(0,8)[0]);
//        System.out.println(con.get(1,0)[0] + " " + con.get(1,1)[0] + " " + con.get(1,2)[0] + " " + con.get(1,3)[0] + " " + con.get(1,4)[0] + " " + con.get(1,5)[0] + " " + con.get(1,6)[0] + " " + con.get(1,7)[0] + " " + con.get(1,8)[0]);
//        System.out.println(con.get(2,0)[0] + " " + con.get(2,1)[0] + " " + con.get(2,2)[0] + " " + con.get(2,3)[0] + " " + con.get(2,4)[0] + " " + con.get(2,5)[0] + " " + con.get(2,6)[0] + " " + con.get(2,7)[0] + " " + con.get(2,8)[0]);
//        System.out.println(con.get(3,0)[0] + " " + con.get(3,1)[0] + " " + con.get(3,2)[0] + " " + con.get(3,3)[0] + " " + con.get(3,4)[0] + " " + con.get(3,5)[0] + " " + con.get(3,6)[0] + " " + con.get(3,7)[0] + " " + con.get(3,8)[0]);
//        System.out.println(con.get(4,0)[0] + " " + con.get(4,1)[0] + " " + con.get(4,2)[0] + " " + con.get(4,3)[0] + " " + con.get(4,4)[0] + " " + con.get(4,5)[0] + " " + con.get(4,6)[0] + " " + con.get(4,7)[0] + " " + con.get(4,8)[0]);
//        System.out.println();
//
//        Imgproc.threshold(con, con, 100000, 255, CvType.CV_8U);
//
//        System.out.println(con.get(0,0)[0] + " " + con.get(0,1)[0] + " " + con.get(0,2)[0] + " " + con.get(0,3)[0] + " " + con.get(0,4)[0] + " " + con.get(0,5)[0] + " " + con.get(0,6)[0] + " " + con.get(0,7)[0] + " " + con.get(0,8)[0]);
//        System.out.println(con.get(1,0)[0] + " " + con.get(1,1)[0] + " " + con.get(1,2)[0] + " " + con.get(1,3)[0] + " " + con.get(1,4)[0] + " " + con.get(1,5)[0] + " " + con.get(1,6)[0] + " " + con.get(1,7)[0] + " " + con.get(1,8)[0]);
//        System.out.println(con.get(2,0)[0] + " " + con.get(2,1)[0] + " " + con.get(2,2)[0] + " " + con.get(2,3)[0] + " " + con.get(2,4)[0] + " " + con.get(2,5)[0] + " " + con.get(2,6)[0] + " " + con.get(2,7)[0] + " " + con.get(2,8)[0]);
//        System.out.println(con.get(3,0)[0] + " " + con.get(3,1)[0] + " " + con.get(3,2)[0] + " " + con.get(3,3)[0] + " " + con.get(3,4)[0] + " " + con.get(3,5)[0] + " " + con.get(3,6)[0] + " " + con.get(3,7)[0] + " " + con.get(3,8)[0]);
//        System.out.println(con.get(4,0)[0] + " " + con.get(4,1)[0] + " " + con.get(4,2)[0] + " " + con.get(4,3)[0] + " " + con.get(4,4)[0] + " " + con.get(4,5)[0] + " " + con.get(4,6)[0] + " " + con.get(4,7)[0] + " " + con.get(4,8)[0]);
//        System.out.println();
//        System.out.println(con);
//
//        Imgcodecs.imwrite(path + "/_" + name, image);

        System.out.println("" + System.nanoTime());

    }
}





//    String path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data/photo";
//    String name;
//    String proc_path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data/proc";
//        File file = new File(path);
//        System.out.println("" + System.nanoTime());
//
//        while (file.list().length > 0) {
//            name = file.list()[0];
//            System.out.println("Processing " + name);
//            Mat image = Imgcodecs.imread(path + "/" + name);
//            Mat hsv = new Mat();
//            Imgproc.cvtColor(image, image, Imgproc.COLOR_RGB2GRAY);
//            Imgproc.Canny(image, hsv, 70, 200);
//            Imgcodecs.imwrite(proc_path + "/" + name, hsv);
//            new File(path + "/" + name).delete();
//        }
//
//        System.out.println("" + System.nanoTime());


//        Mat hsv = new Mat();
//        Imgproc.cvtColor(hsv, hsv, Imgproc.COLOR_GRAY2RGB);
//        Imgproc.cvtColor(hsv, hsv, Imgproc.COLOR_RGB2HSV);
//        Vector<Mat> splitedHsv = new Vector<Mat>();
//        Core.split(hsv, splitedHsv);
//        double[] par;
//        for (int y = 0; y < hsv.cols(); y++) {
//            for (int x = 0; x < hsv.rows(); x++) {
//                // получаем HSV-компоненты пикселя
//                par = hsv.get(x, y);
//                // par[0] Тон
//                // par[1] Интенсивность
//                // par[2] Яркость
//
//                if (par[2] < min) min = par[2];
//                if (par[2] > max) max = par[2];
//
//                //Если яркость слишком низкая либо Тон не попадает у заданный диапазон, то закрашиваем белым
//                if ( (par[2] > 90) ) {
//                    if ((par[1] < 10) && (par[2] > 240))
//                    image.put(x,y,255,255,255);
//                }
//                else {
//                    image.put(x,y,0,0,0);
//                }
//            }
//        }



//        System.out.println("Running DetectRoad");
////        CascadeClassifier signDetector = new CascadeClassifier("C:/Users/r.merdeev/IdeaProjects/OpenCV/data/lbpcascade__5_19_1__2018_02_15__14_32.xml");
//
//        String path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data";
//        String name = "5.jpg";
//        String proc_path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data";
//        File file = new File(path);
//        System.out.println("" + System.nanoTime());
//
//        System.out.println("Processing " + name);
//        Mat image = Imgcodecs.imread(path + "/" + name);
//        Mat hsv = new Mat();
//        Imgproc.cvtColor(image, image, Imgproc.COLOR_RGB2GRAY);
//        Imgproc.blur(image, image, new Size(3,3));
//        Imgproc.Canny(image, hsv, 30, 60, 3, false);
//
//        Imgcodecs.imwrite(proc_path + "/_" + name, hsv);
//
//        System.out.println("" + System.nanoTime());

//    int rows = hsv.rows();
//    int cols = hsv.cols();
//    Mat sub;
//    Scalar summ;
//    Mat ne = new Mat();
//
//        for (int j=0; j<=rows-5; j=j+5) {
//            for (int i=0; i<=cols-9; i++) {
//                sub = hsv.submat(new Rect(i, j, 9, 5));
//                // a60;//sub.mul(a60);
//                Core.multiply(sub, n60, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(100, 100, 100), 1);
//
//                Core.multiply(sub, n45, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(100, 100, 100), 1);
//
//                Core.multiply(sub, n30, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(100, 100, 200), 1);
//
//                Core.multiply(sub, n15, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(100, 100, 200), 1);
//
//                Core.multiply(sub, np0, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(100, 200, 100), 1);
//
//                Core.multiply(sub, p15, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(200, 100, 100), 1);
//
//                Core.multiply(sub, p30, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(200, 100, 100), 1);
//
//                Core.multiply(sub, p45, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(200, 200, 200), 1);
//
//                Core.multiply(sub, p60, ne);
//                summ = Core.sumElems(ne);
//                if (summ.val[0] > 210000) Imgproc.rectangle(image, new Point(i, j), new Point(i+9, j+5), new Scalar(200, 200, 200), 1);
//
////
////                System.out.println("" + summ);
//            }
//        }