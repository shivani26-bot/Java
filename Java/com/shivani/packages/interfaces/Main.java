package com.shivani.packages.interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Engine car1 = new Car();
        // car1.a = 50; // we can't access, because what we will access depends on
        // reference variable , but which version to access depends on object
        // Engine doesn't have a variable , it doesn't have access to variable in Car
        car.acc(); // Car engine accelerating
        car.start(); // Car engine starting
        car.stop();// Car engine stoping
        car.a = 70; // no error

        // Media carMedia = new Car();
        // carMedia.stop(); // Car engine starting, gives incorrect output as engine and
        // media both have
        // // same methods start() and
        // stop()
        // we can create separate classes in same interface to solve this problem

        NiceCar car2 = new NiceCar();
        car2.start(); // Power Engine started
        car2.startMusic(); // car media starts

        car2.upgradeEngine();
        car2.start();// Electric Engine started
    }
}
