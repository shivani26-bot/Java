package com.shivani.packages.properties.polymorphism;

public class Triangle extends Shapes {
    // method overriding- only body is different
    @Override
    void area() {
        System.out.println("Area is 0.5*b*h");
    }
}
