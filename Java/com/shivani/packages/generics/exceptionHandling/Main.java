package com.shivani.packages.generics.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        // Throwable->Exception->RuntimeException->ArithmethicException heirarchy
        int a = 5;
        int b = 0;
        // int c = a / b; // exception error
        // try {
        // int c = a / b; // ArithmeticException

        // } catch (Exception e) {
        // System.out.println(e.getMessage()); /// by zero
        // }

        // try {
        // int c = a / b; // ArithmeticException

        // } catch (ArithmeticException e) {
        // System.out.println(e.getMessage()); /// by zero
        // } finally {
        // System.out.println("this will always execute");
        // }

        // try {
        // divide(a, b); // Division by zero is not allowed

        // } catch (ArithmeticException e) {
        // System.out.println(e.getMessage()); /// by zero
        // } finally {
        // System.out.println("this will always execute"); // this will always execute
        // }

        // try {
        // divide(a, b); // Division by zero is not allowed

        // } catch (Exception e) {
        // System.out.println("Normal exception");
        // }
        // // gives error as Exception is the parent and all type of exceptions are
        // caught by that , no need of ArithmeticException, as it will never execute

        // catch (ArithmeticException e) {
        // System.out.println(e.getMessage()); /// by zero
        // } finally {
        // System.out.println("this will always execute"); // this will always execute
        // }

        // try {
        // divide(a, b); // Division by zero is not allowed

        // }
        // // if arithmetic exception is thrown it will call this catch block other wise
        // it
        // // will call Exception wala catch block
        // catch (ArithmeticException e) {
        // System.out.println(e.getMessage()); /// by zero
        // } catch (Exception e) {
        // System.out.println("Normal exception");
        // } finally {
        // System.out.println("this will always execute"); // this will always execute
        // }

        // try {
        // divide(a, b); // Division by zero is not allowed
        // // mimicing
        // throw new Exception("just for fun");
        // }
        // // if arithmetic exception is thrown it will call this catch block other wise
        // it
        // // will call Exception wala catch block
        // catch (ArithmeticException e) {
        // System.out.println(e.getMessage()); /// by zero
        // } catch (Exception e) {
        // System.out.println("Normal exception");
        // } finally {
        // System.out.println("this will always execute"); // this will always execute
        // }

        try {
            // divide(a, b); // Division by zero is not allowed
            // mimicing
            String name = "shivani";
            if (name.equals("shivani")) {
                throw new MyException("Name is not allowed");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage()); /// by zero
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); /// by zero
        } catch (Exception e) {
            System.out.println("Normal exception");
        } finally {
            System.out.println("this will always execute"); // this will always execute
        }
    }

    // throws is used to declare exception
    // if you use divide it may throw an exception
    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            // throwing an exception
            throw new ArithmeticException("Division by zero is not allowed");
        }

        return a / b;
    }
}
