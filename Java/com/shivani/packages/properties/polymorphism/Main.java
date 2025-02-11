package com.shivani.packages.properties.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();

        // square1 is declared as a reference of type Shapes, but it refers to an object
        // of type Square
        // At compile-time:
        // The compiler checks if the area() method is defined in the Shapes class
        // (reference type). It is, so the code compiles.
        // At runtime:
        // The JVM determines the actual type of the object square1 points to, which is
        // Square. It then invokes the area() method in the Square class.

        // what is accessed is defined by reference type and which one is accessed is
        // defined by object type
        Shapes square1 = new Square(); // Shape class must have method area, but the
        // body of object will be accessed because area method is overriden by Square
        // class
        square1.area(); // Area is side*side ,How is this possible?

        // polymorphism: act of representing same thing in multiple ways, here area() is
        // represented in multiple ways for different shapes

        shape.area();
        circle.area();
        square.area();
    }
}

// Why Variables Are Different
// For member variables, the reference type decides which variable is
// accessible, not the runtime object type. This is because variables are not
// polymorphic in Java.

// Parent obj= new Child();
// Here which method will be called depends on Child()
// This is k now as upcasting

// How Java determins this?
// Dynamic method dispatch-> It's a mechanism by which call to an overidden
// method is resolved at runtime rather than compile time