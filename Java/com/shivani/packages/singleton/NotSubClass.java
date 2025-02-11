package com.shivani.packages.singleton;

public class NotSubClass {

    public static void main(String[] args) {
        NotSubClass obj = new NotSubClass();
        // obj.num = 25;//error, we can't access protected members in differnt package
        // taht is not a subclass
    }
}
