package com.shivani.packages.abstractDemo;

public class Son extends Parent {
    // public class Son extends Parent,Parent2
    // multiple inheritance is not allowed
    public Son(int age) {
        super(age);
        // this.age = age;
    }

    @Override
    void career() {
        System.out.println("I am going to be a doctor");
    }

    @Override
    void partner() {
        System.out.println("I love Zendaya");
    }

    @Override
    void normal() {
        System.out.println("I am normal son");
    }

}
