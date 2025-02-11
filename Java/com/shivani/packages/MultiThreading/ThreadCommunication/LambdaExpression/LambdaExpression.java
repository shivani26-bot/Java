package com.shivani.packages.MultiThreading.ThreadCommunication.LambdaExpression;

public class LambdaExpression {
    public static void main(String[] args) {
        // anonymous new runnable can be replaced with lambda, easy way of writing
        // methods
        // Runnable runnable = new Runnable() {
        // @Override
        // public void run() {
        // System.out.println("Inside Runnable");
        // }
        // };
        Runnable runnable = () -> System.out.println("Inside Runnable");

        // see internal implementation of Runnable, it has annotation
        // @FunctionalInterface-methods in which there are single abstract methods

        // LambdaExpression is a anonymous function ,
        // public void fun(){
        // System.out.println("hello");
        // }
        // // lambda expression
        // ()=> System.out.println("hello");

        Thread t1 = new Thread(runnable);
        // Thread t1 = new Thread(() -> System.out.println("Inside Runnable"));
        t1.start();
    }
}
