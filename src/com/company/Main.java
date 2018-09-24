package com.company;
import org.opencv.core.*;

public class Main {

    static {
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to OpenCV " + Core.VERSION);

        new DetectRoad().run();
    }
}
