package com.shivani.packages.MultiThreading;

// if we want to create thread of class A and class A is already extending another class then we can extend Thread class to class A 
// not allowed
// public class A extends B, Thread {

// }

public class A extends B implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}