package com.shivani.packages.generics;

import java.util.*;
import java.util.function.*;

public class LambdaFunctions {
    // these are inline functions
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i + 1);
        }

        // item represent every single element in arraylist
        // arr.forEach((item) -> System.out.println(item * 2)); //2 4 6 8 10

        // we can assign lambda expressions to variables ie.fun that are typed
        // interfaces ie. Consumer<Integer>
        Consumer<Integer> fun = (item) -> System.out.println(item * 2); // 2 4 6 8 10
        arr.forEach(fun);

        Operation sum = (a, b) -> a + b; // body
        Operation sub = (a, b) -> a - b;
        Operation prod = (a, b) -> a * b;
        LambdaFunctions myCalculator = new LambdaFunctions();
        System.out.println(myCalculator.operate(5, 3, sum)); // 8
        System.out.println(myCalculator.operate(5, 3, sub)); // 2
        System.out.println(myCalculator.operate(5, 3, prod)); // 15
    }

    // int sum(int a, int b) {
    // return a + b;
    // }
    private int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }
}

interface Operation {
    int operation(int a, int b); // abstract method, body is defined above
}