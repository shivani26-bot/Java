package com.shivani.packages.MultiThreading;

// https://www.youtube.com/watch?v=4aYvLz4E1Ts
public class Main {
    public static void main(String[] args) {
        // another thread, both the threads execute randomly as both are two independent
        // 1st method
        // World world = new World();
        // world.start(); // start method is called to initiate the new thread

        // // main thread
        // for (int i = 0; i < 10000; i++) {
        // // System.out.println("Hello ");
        // System.out.println(Thread.currentThread().getName()); // main
        // }

        // // wrong
        // for (;;) {
        // System.out.println(Thread.currentThread().getName());
        // }
        // // unreachable
        // for (;;) {
        // System.out.println(Thread.currentThread().getName());
        // }

        // 2nd method
        World world = new World();
        // a thread object is created by passing an instance of World
        Thread t1 = new Thread(world);
        // start method is called on the thread object to initiate the new thread
        t1.start();
        for (;;) {
            System.out.println("Hello ");
            // System.out.println(Thread.currentThread().getName()); // main
        }

        // In both the cases run method contains the code that will be executed in the
        // new thread
    }

}

// Thread.currentThread().getName() method in Java used to retrieve the name of
// the currently executing thread.
// Thread.currentThread(): Returns a reference to the currently executing
// thread.
// .getName(): Fetches the name of that thread.

// In order to run multiple threads create multiple classes
// if you want Hello to run in one thread and world to run in another thread,
// create two classes

// https://www.youtube.com/watch?v=4aYvLz4E1Ts