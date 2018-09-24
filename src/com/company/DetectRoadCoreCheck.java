package com.company;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;

/*
 * Detects signs in an image, draws boxes around them, and writes the results
 * to "signDetection.png".
 */
public class DetectRoadCoreCheck {

    public void run() {
        System.out.println("Running DetectRoad");

        String name = "around.tif";
        String proc_path = "C:/Users/r.merdeev/IdeaProjects/OpenCV/data/lines/incline";
        System.out.println("" + System.nanoTime());

        System.out.println("Processing " + name);
        Mat image = Imgcodecs.imread(proc_path + "/" + name);

        Mat sub = image;

        System.out.println(sub.get(0,0)[0] + " " + sub.get(0,1)[0] + " " + sub.get(0,2)[0] + " " + sub.get(0,3)[0] + " " + sub.get(0,4)[0] + " " + sub.get(0,5)[0] + " " + sub.get(0,6)[0] + " " + sub.get(0,7)[0] + " " + sub.get(0,8)[0]);
        System.out.println(sub.get(1,1)[0] + " " + sub.get(1,1)[0] + " " + sub.get(1,2)[0] + " " + sub.get(1,3)[0] + " " + sub.get(1,4)[0] + " " + sub.get(1,5)[0] + " " + sub.get(1,6)[0] + " " + sub.get(1,7)[0] + " " + sub.get(1,8)[0]);
        System.out.println(sub.get(2,0)[0] + " " + sub.get(2,1)[0] + " " + sub.get(2,2)[0] + " " + sub.get(2,3)[0] + " " + sub.get(2,4)[0] + " " + sub.get(2,5)[0] + " " + sub.get(2,6)[0] + " " + sub.get(2,7)[0] + " " + sub.get(2,8)[0]);
        System.out.println(sub.get(3,0)[0] + " " + sub.get(3,1)[0] + " " + sub.get(3,2)[0] + " " + sub.get(3,3)[0] + " " + sub.get(3,4)[0] + " " + sub.get(3,5)[0] + " " + sub.get(3,6)[0] + " " + sub.get(3,7)[0] + " " + sub.get(3,8)[0]);
        System.out.println(sub.get(4,0)[0] + " " + sub.get(4,1)[0] + " " + sub.get(4,2)[0] + " " + sub.get(4,3)[0] + " " + sub.get(4,4)[0] + " " + sub.get(4,5)[0] + " " + sub.get(4,6)[0] + " " + sub.get(4,7)[0] + " " + sub.get(4,8)[0]);

        System.out.println("" + System.nanoTime());

    }
}
