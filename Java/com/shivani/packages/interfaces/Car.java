package com.shivani.packages.interfaces;

// if car needs all the three functionalities, ie brake, engine, media 
// we are inheriting properties of more than one class in a Car class 
public class Car implements Engine, Brake, Media {
    int a = 30;

    @Override
    public void brake() {
        System.out.println("Car braking");
    }

    @Override
    public void start() {
        System.out.println("Car engine starting");
    }

    @Override
    public void stop() {
        System.out.println("Car engine stoping");
    }

    @Override
    public void acc() {
        System.out.println("Car engine accelerating");
    }

}
