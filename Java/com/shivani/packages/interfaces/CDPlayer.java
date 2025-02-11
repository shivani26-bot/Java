package com.shivani.packages.interfaces;

public class CDPlayer implements Media {

    @Override
    public void start() {
        System.out.println("car media starts");
    }

    @Override
    public void stop() {
        System.out.println("car media stops");
    }
}
