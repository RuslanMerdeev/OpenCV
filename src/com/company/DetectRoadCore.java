package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;

/*
 * Detects signs in an image, draws boxes around them, and writes the results
 * to "signDetection.png".
 */
public class DetectRoadCore {

    public void run() {
        System.out.println("Running DetectRoad");

        String path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data/lines";
        String name = "np0.tif";
        String proc_path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data";
        System.out.println("" + System.nanoTime());

        System.out.println("Processing " + name);
        Mat image = Imgcodecs.imread(path + "/" + name);

        Imgproc.cvtColor(image, image, Imgproc.COLOR_RGB2GRAY);

        Imgproc.blur(image, image, new Size(2, 2));
        image.convertTo(image, CvType.CV_16S);

        Mat sub;
        Mat rot = new Mat();
//p60
//        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
//        Core.add(image.submat(new Rect(2, 2, 9, 5)), sub, sub);
//        Core.add(image.submat(new Rect(3, 2, 9, 5)), sub, sub);
//        Core.add(image.submat(new Rect(4, 3, 9, 5)), sub, sub);
//        Core.add(image.submat(new Rect(5, 4, 9, 5)), sub, sub);
//        Core.add(image.submat(new Rect(6, 4, 9, 5)), sub, sub);
//        Core.multiply(sub, new Scalar(0.4), sub);

//p45
//        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
//        Core.add(image.submat(new Rect(2, 4, 9, 5)), sub, sub);
//        Core.multiply(sub, new Scalar(2.0), sub);

//p30
//        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
//        Core.add(image.submat(new Rect(1, 6, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(1, 6, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(1, 7, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(1, 7, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(2, 8, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(2, 8, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(3, 9, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(3, 9, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(4, 10, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(4, 10, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.multiply(sub, new Scalar(0.2), sub);

//p15
//        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
//        Core.add(image.submat(new Rect(11, 57, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(11, 57, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(12, 58, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(12, 58, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(12, 59, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(12, 59, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(12, 60, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(12, 60, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(13, 61, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(13, 61, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.multiply(sub, new Scalar(0.2), sub);

//np0
        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
        Core.add(image.submat(new Rect(45, 2, 9, 5)), sub, sub);
        Core.rotate(image.submat(new Rect(45, 2, 9, 5)), rot, Core.ROTATE_180);
        Core.add(rot, sub, sub);
        Core.multiply(sub, new Scalar(1.0), sub);

//n15
//        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
//        Core.add(image.submat(new Rect(81, 57, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(81, 57, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(80, 58, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(80, 58, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(80, 59, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(80, 59, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(80, 60, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(80, 60, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(79, 61, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(79, 61, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.multiply(sub, new Scalar(0.2), sub);

//n30
//        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
//        Core.add(image.submat(new Rect(91, 6, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(91, 6, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(91, 7, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(91, 7, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(90, 8, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(90, 8, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(89, 9, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(89, 9, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.add(image.submat(new Rect(88, 10, 9, 5)), sub, sub);
//        Core.rotate(image.submat(new Rect(88, 10, 9, 5)), rot, Core.ROTATE_180);
//        Core.add(rot, sub, sub);
//        Core.multiply(sub, new Scalar(0.2), sub);

//n45
//        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
//        Core.add(image.submat(new Rect(90, 4, 9, 5)), sub, sub);
//        Core.multiply(sub, new Scalar(2.0), sub);

//n60
//        sub = Mat.zeros(new Size(9, 5), CvType.CV_16S);
//        Core.add(image.submat(new Rect(90, 2, 9, 5)), sub, sub);
//        Core.add(image.submat(new Rect(89, 2, 9, 5)), sub, sub);
//        Core.add(image.submat(new Rect(88, 3, 9, 5)), sub, sub);
//        Core.add(image.submat(new Rect(87, 4, 9, 5)), sub, sub);
//        Core.add(image.submat(new Rect(86, 4, 9, 5)), sub, sub);
//        Core.multiply(sub, new Scalar(0.4), sub);

        System.out.println(sub.get(0,0)[0] + " " + sub.get(0,1)[0] + " " + sub.get(0,2)[0] + " " + sub.get(0,3)[0] + " " + sub.get(0,4)[0] + " " + sub.get(0,5)[0] + " " + sub.get(0,6)[0] + " " + sub.get(0,7)[0] + " " + sub.get(0,8)[0]);
        System.out.println(sub.get(1,0)[0] + " " + sub.get(1,1)[0] + " " + sub.get(1,2)[0] + " " + sub.get(1,3)[0] + " " + sub.get(1,4)[0] + " " + sub.get(1,5)[0] + " " + sub.get(1,6)[0] + " " + sub.get(1,7)[0] + " " + sub.get(1,8)[0]);
        System.out.println(sub.get(2,0)[0] + " " + sub.get(2,1)[0] + " " + sub.get(2,2)[0] + " " + sub.get(2,3)[0] + " " + sub.get(2,4)[0] + " " + sub.get(2,5)[0] + " " + sub.get(2,6)[0] + " " + sub.get(2,7)[0] + " " + sub.get(2,8)[0]);
        System.out.println(sub.get(3,0)[0] + " " + sub.get(3,1)[0] + " " + sub.get(3,2)[0] + " " + sub.get(3,3)[0] + " " + sub.get(3,4)[0] + " " + sub.get(3,5)[0] + " " + sub.get(3,6)[0] + " " + sub.get(3,7)[0] + " " + sub.get(3,8)[0]);
        System.out.println(sub.get(4,0)[0] + " " + sub.get(4,1)[0] + " " + sub.get(4,2)[0] + " " + sub.get(4,3)[0] + " " + sub.get(4,4)[0] + " " + sub.get(4,5)[0] + " " + sub.get(4,6)[0] + " " + sub.get(4,7)[0] + " " + sub.get(4,8)[0]);


        Imgcodecs.imwrite(proc_path + "/" + name, sub);

        System.out.println("" + System.nanoTime());

    }
}
