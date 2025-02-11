package com.shivani.packages.access;

public class A {
    // data members
    // private int num; // we can't access this outside the class now, data hiding

    // public int num;//public accessible anywhere , no need of getters and setters
    // to access outside the class

    // int num; // default modifier

    protected int num; // protected modifier

    String name;
    int[] arr;

    // to access private members outside the class use getters and setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
}

// private members are accessible inside the class in which they are declared
// public members are accessible everywhere.
// when num is declared as default modifier ie int num it's not accessible in
// different package but we can access it in same package
// when num is declared as protected modifier it's not accessible
// in different package but we can access it in same package