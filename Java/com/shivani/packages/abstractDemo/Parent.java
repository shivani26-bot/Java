package com.shivani.packages.abstractDemo;

// abstraction doesn't solves the problem of multiple inheritance as it allows normal methods , the same problem will occur if two mthods have same name
public abstract class Parent {

    // we can never have final abstract class, because final keyword prevents
    // classes from being inherited
    // final public abstract class Parent //wrong

    // static int age; // we can have static variable inside abstract classes
    int age; // use this in constructor of subclasses

    final int VALUE; // initialize this in constructor

    // we can also define constructor of parent class
    // but we can't instantiate abstract class directly but we can use super keyword
    // in subclasses to reference to it
    public Parent(int age) {
        this.age = age;
        VALUE = 12341234;
    }

    // we can have static methods, because there can be no objects for abstract
    // classes
    static void hello() {
        System.out.println("Hello from Parent");
    }

    // abstract classes can contain normal methods
    void normal() {
        System.out.println("I am normal method in Parent");
    }

    // abstract Parent(); // error, we can't create abstract constructor
    abstract void career();

    abstract void partner();

    // if we can create objects of abstract classes and we call the methods of
    // abstract classes like career or partner , it will give error as they don't
    // have body

    // we can't create abstract static methods as abstract methods needs to be
    // overidden but static methods never override

    // we can create static methods in abstract classes

}
