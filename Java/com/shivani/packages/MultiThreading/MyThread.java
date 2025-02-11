package com.shivani.packages.MultiThreading;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING...");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState()); // NEW
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE
        System.out.println(Thread.currentThread().getState()); // RUNNABLE, gives the state of main thread
        // In java we don't have running state, runnable is considered as running
        Thread.sleep(100);
        System.out.println(t1.getState());// TIMED_WAITING
        t1.join(); // Waits for this thread to die, main method is waiting t1 to get finished, once
                   // 4000 ms is over
        System.out.println(t1.getState());// TERMINATED
    }
}
