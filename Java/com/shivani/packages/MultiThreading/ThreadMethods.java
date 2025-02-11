package com.shivani.packages.MultiThreading;

public class ThreadMethods extends Thread {

    // we can give custom names to the thread
    public ThreadMethods(String name) {
        super(name);
    }

    @Override
    // public void run() {
    // // what work we want to do in this thread
    // System.out.println("Thread is running....");
    // for (int i = 1; i <= 5; i++) {
    // System.out
    // .println(Thread.currentThread().getName() + " - Priority: " +
    // Thread.currentThread().getPriority()
    // + " - count " + i);
    // // without giving custom name : Thread-0 - Priority: 5 - count 1, Thread-0 -
    // // Priority: 5 - count 2, Thread-0 - Priority: 5 - count 3,Thread-0 -
    // Priority:
    // // 5 - count 4,Thread-0 - Priority: 5 - count 5
    // // giving custom name : shivani - Priority: 5 - count 1, shivani -
    // // Priority: 5 - count 2, shivani - Priority: 5 - count 3,shivani
    // // - Priority: 5 - count 4,shivani - Priority: 5 - count 5
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // throw new RuntimeException(e);
    // }
    // // System.out.println(i);
    // }

    // public void run() {
    // // what work we want to do in this thread
    // System.out.println("Thread is running....");
    // for (int i = 1; i <= 5; i++) {
    // System.out
    // .println(Thread.currentThread().getName() + " is running");
    // Thread.yield();
    // // hint to the thread scheduler that the current thread is willing to pause
    // and
    // // let other threads of the same priority execute if they are ready. However,
    // it
    // // does not guarantee that the thread will stop running—it depends on the
    // thread
    // // scheduler's implementation.

    // }
    // }

    public void run() {
        while (true) {
            System.out.println("Hello World !");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // ThreadMethods t1 = new ThreadMethods("shivani");

        // t1.start(); // jvm will start the thread, and runs the run() method
        // // Thread is running....
        // // 1
        // // 2
        // // 3
        // // 4
        // // 5

        // t1.interrupt(); // whatever task is being performed in t1 will be interrupted

        // t1.join();// main threads waits for t1 to end and then execute the further
        // instructions in
        // // the main thread
        // System.out.println("Hello"); // Hello

        // // we can setPriority to the thread
        // // MIN_PRIORITY=1, MAX_PRIORITY=10, NORM_PRIORITY=5
        // // We can help cpu to decide which thread to run by setting their priority
        // ThreadMethods l = new ThreadMethods("Low Priority Thread");
        // ThreadMethods m = new ThreadMethods("Medium Priority Thread");
        // ThreadMethods h = new ThreadMethods("High Priority Thread");

        // l.setPriority(Thread.MIN_PRIORITY);
        // m.setPriority(Thread.NORM_PRIORITY);
        // h.setPriority(Thread.MAX_PRIORITY);

        // l.start();
        // m.start();
        // h.start();
        // High Priority Thread - Priority: 10 - count 1
        // Low Priority Thread - Priority: 1 - count 1
        // Medium Priority Thread - Priority: 5 - count 1
        // High Priority Thread - Priority: 10 - count 2
        // Low Priority Thread - Priority: 1 - count 2
        // Medium Priority Thread - Priority: 5 - count 2
        // High Priority Thread - Priority: 10 - count 3
        // Medium Priority Thread - Priority: 5 - count 3
        // Low Priority Thread - Priority: 1 - count 3
        // High Priority Thread - Priority: 10 - count 4
        // Medium Priority Thread - Priority: 5 - count 4
        // Low Priority Thread - Priority: 1 - count 4
        // High Priority Thread - Priority: 10 - count 5
        // Low Priority Thread - Priority: 1 - count 5
        // Medium Priority Thread - Priority: 5 - count 5

        // setPriority gives hint to keep certain thread at high priority, but whether
        // priority will be set to high or not will depend on the code or or jvm or task
        // we are performing in the thread

        // ThreadMethods t2 = new ThreadMethods("t2");
        // ThreadMethods t3 = new ThreadMethods("t3");
        // t2.start();
        // t3.start();
        // with yield()
        // Thread is running....
        // Thread is running....
        // t3 is running
        // t2 is running
        // t3 is running
        // t2 is running
        // t3 is running
        // t2 is running
        // t3 is running
        // t2 is running
        // t3 is running
        // t2 is running
        // without yield()
        // t2 is running
        // t2 is running
        // t3 is running
        // t2 is running
        // t3 is running
        // t2 is running
        // t3 is running
        // t2 is running
        // t3 is running
        // t3 is running

        // ThreadMethods t4 = new ThreadMethods("t4");// user thread which does our
        // work, threads which is used to perform
        // useful work is called user thread
        // jvm doesn't wait for daemon threads , here t4 is set as daemon thread
        // it will start the thread and t4 goes into runnable state, cpu will run the
        // statements inside run() , main thread moves to the next statement, prints
        // Main done and terminate because t4 is daemon thread
        // t4.setDaemon(true); //now t4 is daemon thread
        // t4.start();
        // System.out.println("Main done");
        // Main done
        // Hello World !
        // Hello World !
        // Hello World !
        // Hello World !

        ThreadMethods t4 = new ThreadMethods("t4"); // user thread
        t4.setDaemon(true);// now t4 is daemon thread
        ThreadMethods t5 = new ThreadMethods("t5"); // user thread
        t5.start();
        t4.start();
        System.out.println("Main done");
        // here main thread will wait for t5 to finish as it's user thread
    }
}

// start run sleep join setPriority interrupt setDeamon

// DAEMON THREADS-> threads which runs in background, for ex: garbage collector
// in java, jvm will not wait for this thread to finish