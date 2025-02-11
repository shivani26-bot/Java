package com.shivani.packages.MultiThreading.ThreadCommunication.LambdaExpression;

public class Main {
    public static void main(String[] args) {
        // EngineeringStudent student = new EngineeringStudent();
        // String ram = student.getBio("Ram");
        // System.out.println(ram);

        // Student student = new Student() {
        // @Override
        // public String getBio(String name) {
        // return "Hello, I am " + name + " from a student";
        // }
        // };
        // as Student interface only has one method we can use lambda expression

        // Student student = (String name) -> {
        // return "Hello, I am " + name + " from a student";
        // };

        // Student student = (name) -> {
        // return "Hello, I am " + name + " from a student";
        // };
        // Student student = name -> {
        // return "Hello, I am " + name + " from a student";
        // };
        Student student = name -> "Hello, I am " + name + " from a student";

        String bio = student.getBio("shivani");
        System.out.println(bio);
    }
}
