package com.shivani.packages.singleton;

public class Singleton {
    // we can't access num in other file within same package because its declared
    // private , but we can use it within the same class
    // private int num = 0;

    // we can create object of singleton class within the same package if the
    // constructor is public bydefault
    // Singleton() {

    // }
    // we can't create object of singleton class within the same package if the
    // constructor is private
    private Singleton() {

    }

    // instance will not be dependent on object of singleton class hence declare
    // static
    private static Singleton instance;

    public static Singleton getInstance() {
        // check whether 1 object only is created or not
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
