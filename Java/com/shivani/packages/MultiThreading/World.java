package com.shivani.packages.MultiThreading;

// 1st method 
// public class World extends Thread {
//     @Override
//     // a new class world is created that extends thread
//     // the run method is overridden to define the code that constitutes the new
//     // thread
//     public void run() {
//         for (int i = 0; i < 10000; i++) {
//             // System.out.println("World");
//             System.out.println(Thread.currentThread().getName()); // thread-0
//         }
//     }
// }
// 2nd method 
// a new class world is created that implements runnable 
public class World implements Runnable {
    @Override
    // the run method is overridden to define the code that constitutes the new
    // thread.
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("World");
            // System.out.println(Thread.currentThread().getName()); // thread-0
        }
    }
}