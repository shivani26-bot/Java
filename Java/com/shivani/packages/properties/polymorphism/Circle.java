package com.shivani.packages.properties.polymorphism;

public class Circle extends Shapes {
    // method overriding
    // this will run when object of Circle is created hence it is overriding the
    // parent method

    @Override // annotations
    void area() {
        System.out.println("Area is pi*r*r");
    }
}
