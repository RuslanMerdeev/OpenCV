package com.company;
import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.Locale;
import java.util.Scanner;

class AddingImagesRun{
    public void run() {
        double alpha = 0.5; double beta; double input;

        Mat src1, src2, dst = new Mat();

        System.out.println(" Simple Linear Blender ");
        System.out.println("-----------------------");
        System.out.println("* Enter alpha [0.0-1.0]: ");
        Scanner scan = new Scanner( System.in ).useLocale(Locale.US);
        input = scan.nextDouble();

        if( input >= 0.0 && input <= 1.0 )
            alpha = input;

        //! [load]
        src1 = Imgcodecs.imread("C:/Users/r.merdeev/IdeaProjects/OpenCV/data/atom1.jpg");
        src2 = Imgcodecs.imread("C:/Users/r.merdeev/IdeaProjects/OpenCV/data/atom2.jpg");
        //! [load]

        if( src1.empty() == true ){ System.out.println("Error loading src1"); return;}
        if( src2.empty() == true ){ System.out.println("Error loading src2"); return;}

        //! [blend_images]
        beta = ( 1.0 - alpha );
        Core.addWeighted( src1, alpha, src2, beta, 0.0, dst);
        //! [blend_images]

        //![display]
        Highgui.selectROI("Linear Blend", dst);
        Highgui.waitKeyEx(0);
        //![display]

        System.exit(0);
    }
}
