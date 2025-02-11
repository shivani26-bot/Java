package com.shivani.packages.abstractDemo;

public abstract class Parent2 {

    int age; // use this in constructor of subclasses
    final int VALUE; // initialize this in constructor

    public Parent2(int age) {
        this.age = age;
        VALUE = 12341234;
    }

    static void hello() {
        System.out.println("Hello from Parent");
    }

    void normal() {
        System.out.println("I am normal method in Parent");
    }

    // abstract Parent(); // error, we can't create abstract constructor
    abstract void career();

    abstract void partner();

}
