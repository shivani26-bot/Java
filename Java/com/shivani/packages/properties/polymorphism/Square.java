package com.shivani.packages.properties.polymorphism;

public class Square extends Shapes {
    // method overriding
    @Override
    void area() {
        System.out.println("Area is side*side");
    }
}
