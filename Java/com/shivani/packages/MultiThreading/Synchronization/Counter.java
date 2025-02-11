package com.shivani.packages.MultiThreading.Synchronization;

public class Counter {

    private int count = 0;

    // public void increment() {
    // count++;
    // }

    // this make sure if one thread is accessing this method then other thread will
    // wait in order to access this
    public synchronized void increment() {
        count++;
    }

    // public void increment() {
    // // if we don't want entire increment method to be synchronized but we want a
    // // block of code only to be synchronized
    // // this refers to current instance or threado= on which increment() method is
    // // called
    // synchronized (this) {
    // count++;
    // }

    // }

    public int getCount() {
        return count;
    }

}
