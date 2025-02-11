package com.shivani.packages.singleton;

import com.shivani.packages.access.A;

public class SubClass extends A {
    public SubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        SubClass obj1 = new SubClass(45, "shivani");
        obj1.num = 25;// we can access protected members in subclass in different same package

        // // this is not allowed, only via subclass we can access protected members
        // outside the package, A doesn't know what subclass is but subclas knows what
        // it's extending
        A obj = new A(45, "shivani"); // error
        // obj.num = 25;// error
    }
}

class SubSubClass extends SubClass {
    public SubSubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {

        SubSubClass obj = new SubSubClass(45, "shivani"); // error
        obj.num = 25;// no error,. can access protected member
    }
}

class SubClass2 extends A {
    public SubClass2(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {

        SubClass2 obj = new SubClass2(45, "shivani"); // error
        obj.num = 25;// no, error
    }
}
