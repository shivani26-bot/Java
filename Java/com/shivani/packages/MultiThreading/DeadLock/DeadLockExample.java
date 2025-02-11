package com.shivani.packages.MultiThreading.DeadLock;

// this code creates deadlock and runs indefinately 
// how to resolve the deadlock issue 
// ensure that all the threads acquire the lock in consistent order 

// thread 1 has pen 
class Pen {
    // this method will acquire intrinsic lock of the object of the method belongs
    // to

    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(
                Thread.currentThread().getName() + " is using pen " + this + " and trying to use paper " + paper);
        paper.finishWriting(); // this method has lock of pen and it tries to acquire lock of paper
    }

    // it will run when it has lock of pen
    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
    }
}

class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(
                Thread.currentThread().getName() + " is using paper " + this + " and trying to use pen " + pen);
        pen.finishWriting();// this method has lock of paper and it tries to acquire lock of pen
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
    }
}

// task 1 first wants lock of pen and then lock of paper
class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper); // thread 1 locks pen and tries to lock paper
    }
}

// task 2 first wants lock of paper and then lock of pen
// class Task2 implements Runnable {
// private Pen pen;
// private Paper paper;

// public Task2(Pen pen, Paper paper) {
// this.pen = pen;
// this.paper = paper;
// }

// @Override
// public void run() {
// paper.writeWithPaperAndPen(pen); // thread2 locks paper and tries to lock pen
// }
// }

// to get rid of deadlock situation
class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        // this will ensure that thread 2 will acquire lock on paper only when it has
        // lock of pen
        // consistent ordering
        synchronized (pen) {
            paper.writeWithPaperAndPen(pen); // thread2 locks paper and tries to lock pen
        }
    }
}

public class DeadLockExample {

    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread thread1 = new Thread(new Task1(pen, paper), "Thread - 1");
        Thread thread2 = new Thread(new Task2(pen, paper), "Thread - 2");

        thread1.start();
        thread2.start();

    }
}
