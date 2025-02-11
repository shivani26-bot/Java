package com.shivani.packages.abstractDemo;

public class Daughter extends Parent {
    public Daughter(int age) {
        super(age);
        // this.age = age;
    }

    @Override
    void career() {
        System.out.println("I am going to be a engineer");
    }

    @Override
    void partner() {
        System.out.println("I love Iron Man");
    }
}
