package com.shivani.packages.properties.inheritance;

public class Box {
    // final will prevent this class from being inherited
    // when we put class as final implictly it puts all its method to final
    // public final class Box {
    private double l1 = 2;// if declared private can't be accessed outside this class, it is data hiding
    double l;
    double w;
    double h;
    double weight;

    Box() {
        this.h = -1;
        this.l = -1;
        this.w = -1;
    }

    // we use getters and setters to access private member, it is encapsulation, we
    // are implementing getters function to return the private member of the class
    // so that
    // they can be accessed outside the class
    public double getL() {
        return l1;
    }

    // static methods are not dependent on objects of class ie Box
    // we can't override static methods
    static void greeting() {
        System.out.println("Hey i am in box class, greetings!");
    }

    // cube
    Box(double side) {

        // every single class we create has object as its super class or every class
        // inherits object class
        // super points to directly above class
        super(); // points to object class, here box is the top level class, it is derived from
                 // object class

        this.h = side;
        this.l = side;
        this.w = side;
    }

    Box(double l, double h, double w) {
        System.out.println("box class constructor");
        this.l = l;
        this.h = h;
        this.w = w;
    }

    // copy constructor
    Box(Box old) {
        this.h = old.h;
        this.l = old.l;
        this.w = old.w;
    }

    public void information() {
        System.out.println("Running the box ");
    }
}
