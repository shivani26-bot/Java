package com.shivani.packages.interfaces.nestedInterfaces;

public class A {
    // nested interface can be declared as public private and protected, but top
    // level interface has to be declared public or default

    public interface NestedInterface {
        boolean isOdd(int num);
    }
}

class B implements A.NestedInterface {
    @Override
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}
