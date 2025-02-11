package com.shivani.packages.interfaces.annotations;

public class Main implements A, B {

    @Override
    public void greet() {

    }
    // the access modifier for overriden methods should be same or less restrictive
    // for ex: if parent class has a protected method, then when this method is
    // overidden then it should be protected or public

    // @Override
    // private void greet() { //this is wrong

    // }

    public static void main(String[] args) {
        Main obj = new Main();
        A.greeting();
    }
}
