package com.shivani.packages.singleton;

import com.shivani.packages.access.A;

public class Main {
    public static void main(String[] args) {
        // Singleton obj = new Singleton();
        // obj.num = 40;// we can't access it becasue num is declared as private within
        // same package

        // only one object is created in the memory, all three reference variables are
        // pointing to just one object
        Singleton obj = Singleton.getInstance();
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        A a = new A(12, "shivani");
        a.getNum();// when num is declared as private
        // int n = a.num; // error, because when num is declared as default modifier ie
        // int num it's not accessible in different package but we can access it in same
        // package
        int n = a.num;// error, because when num is declared as protected modifier it's not accessible
                      // in different package but we can access it in same
        // package

    }
}
