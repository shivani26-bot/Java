package com.shivani.packages.properties.polymorphism;

public class Shapes {

    void area() {
        System.out.println("I am in shapes");
    }

    // early bindings
    // once declared final , we can't override area() in Circle Square Trianlge or
    // any other class
    // final void area() {
    // System.out.println("I am in shapes");
    // }
}
