package com.shivani.staticExample;

public class StaticBlock {

    static int a = 4;
    static int b;
    // static block
    // will only run once, when the first obj is created ie. when the class is
    // loaded for the first time
    // executed once, when the class is executed
    // even though we create object twice , static block will be executed once
    static {
        System.out.println("I am in static block");
        // we can initialize static variables here
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        // as soon the StaticBlock class is loaded all the static elements are run first

        System.out.println(StaticBlock.a + " " + StaticBlock.b); // 4 20

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // 4 23

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // 4 23
        // here b is not initialized again, it will use the already initialized value
    }
}
