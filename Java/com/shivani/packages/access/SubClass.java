package com.shivani.packages.access;

public class SubClass extends A {
    public SubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass(45, "shivani");
        obj.num = 25;// we can access protected members in subclass withing same package
        System.out.println(obj instanceof A);// true
        System.out.println(obj instanceof Object);// true
    }
}
