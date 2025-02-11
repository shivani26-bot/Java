package com.shivani.packages.interfaces;

public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric Engine started");
    }

    @Override
    public void stop() {
        System.out.println("Electric Engine stopped");
    }

    @Override
    public void acc() {
        System.out.println("Electric Engine accelerate");
    }
}
