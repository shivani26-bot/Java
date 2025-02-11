package com.shivani.packages.access;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        A obj = new A(10, "shivani");

        // access the data members
        // modify the data members

        // ArrayList<Integer> list = new ArrayList<>(23);
        // list.DEFAULT_CAPACITY; //DEFAULT_CAPACITY declared as private static final in
        // internal implementation of arraylist hence we can't access it, but can modify
        // this using public constructor in arraylist

        // obj.setNum(4);
        System.out.println(obj.getNum());// 4

        System.out.println(obj.num);// no error, when num is declared as default modifier ie int num it's not
                                    // accessible in
        // different package but we can access it in same package
        System.out.println(obj.num);// no error, when num is declared as protected modifier it's not
        // accessible in different package but we can access it in same package
    }
}
