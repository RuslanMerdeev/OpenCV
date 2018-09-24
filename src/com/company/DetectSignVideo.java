package com.company;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;

/*
 * Detects signs in an image, draws boxes around them, and writes the results
 * to "signDetection.png".
 */
public class DetectSignVideo {
    double min = 2000;
    double max = 0;
    public void run() {
        System.out.println("Running DetectSignVideo");

        CascadeClassifier signDetector = new CascadeClassifier("C:/Users/r.merdeev/IdeaProjects/OpenCV/data/lbpcascade__5_19_1__2018_02_15__14_32.xml");
        VideoCapture videoCapture = new VideoCapture("C:/Users/r.merdeev/IdeaProjects/OpenCV/data/v_cut.mp4");
        Mat frame = new Mat();
        MatOfRect signDetections = new MatOfRect();
        VideoWriter videoWriter = new VideoWriter("C:/Users/r.merdeev/IdeaProjects/OpenCV/data/signDetection.mp4",VideoWriter.fourcc('X','V','I','D'),30,new Size(1280,720));



        System.out.println("" + System.nanoTime());
        while (videoCapture.read(frame)) {
            //System.out.println("1: " + System.nanoTime());
            signDetector.detectMultiScale(frame, signDetections, 1.3, 1, 0, new Size(20 ,20), new Size(100, 100));
            //System.out.println("2: " + System.nanoTime());
            for (Rect rect : signDetections.toArray()) {
                //System.out.println("3: " + System.nanoTime());
                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x
                        + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 2);
                if (rect.width < min) min = rect.width;
                if (rect.width > max) max = rect.width;
            }
            videoWriter.write(frame);
        }
        System.out.println("Stop");
        videoWriter.release();
        System.out.println("" + System.nanoTime());
        System.out.println("min: " + min + "; max: " + max);
    }
}
