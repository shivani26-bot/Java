package com.shivani.packages.properties.polymorphism;

// compile time polymorphism
public class Number {
    // method overloading
    int sum(int a, int b) {
        return a + b;
    }

    // this is wrong
    // int sum(int b, int a) {
    // return a + b;
    // }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Number obj = new Number();
        obj.sum(2, 3);
        obj.sum(2, 3, 4);
        // obj.sum(2, 3, 4, 5); //error
    }
}
