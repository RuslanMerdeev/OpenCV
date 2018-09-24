package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.util.ArrayList;
import java.util.List;

/*
 * Detects signs in an image, draws boxes around them, and writes the results
 * to "signDetection.png".
 */
public class DetectSign {
    public void run() {
        System.out.println("\nRunning DetectSign");

        // Create a sign detector from the cascade file in the resources
        // directory.
        CascadeClassifier faceDetector = new CascadeClassifier("C:/Users/r.merdeev/IdeaProjects/OpenCV/data/cascade_2018_02_14_13_49.xml");
        Mat image = Imgcodecs.imread("C:/Users/r.merdeev/IdeaProjects/OpenCV/data/4.jpg");
        System.out.println("" + System.nanoTime());

        // Detect faces in the image.
        // MatOfRect is a special container class for Rect.
//        MatOfRect faceDetections = new MatOfRect();
//        faceDetector.detectMultiScale(image, faceDetections);
//
//        System.out.println(String.format("Detected %s signs",
//                faceDetections.toArray().length));
//
//        // Draw a bounding box around each face.
//        for (Rect rect : faceDetections.toArray()) {
//            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
//                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
//        }
        Mat im = new Mat();
        Imgproc.Canny(image, im, 40, 70);

        System.out.println("Stop");
        System.out.println("" + System.nanoTime());
        // Save the visualized detection.
        String filename = "data/signDetection.jpg";
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, im);
    }
}
