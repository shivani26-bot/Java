package com.shivani.packages.abstractDemo;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(30);
        son.career();

        son.normal();
        Daughter daughter = new Daughter(25);
        daughter.career();
        daughter.normal(); // I am normal method in Parent. invokes method in Parent class if we don't
                           // override normal method in subclass Daughter

        // even though we can't create objects of abstract class but we can create a
        // reference to it
        Parent daughter1 = new Daughter(25);
        daughter1.career();// I am going to be a engineer

        // we can't create objects on abstract class
        // if we can create objects of abstract classes and we call the methods of
        // abstract classes like career or partner , it will give error as they don't
        // have body

        // Parent mom = new Parent(45); // error

        Parent.hello(); // Hello from Parent
    }

}
