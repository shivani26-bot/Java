package com.shivani.packages.properties.inheritance;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        System.out.println(box.l + " " + box.h + " " + box.w); // -1.0 -1.0 -1.0
        Box box1 = new Box(4);
        // accesing private memeber of class, use getters
        System.out.println(box1.getL()); // 2.0, we are accesing l1 via method declared in the same class where l1 is
                                         // declared private and that method is public

        // System.out.println(box1.l + " " + box1.h + " " + box1.w); // 4.0 4.0 4.0
        Box box2 = new Box(4, 5, 6);
        System.out.println(box2.l + " " + box2.h + " " + box2.w); // 4.0 5.0 6.0
        Box box3 = new Box(box2);
        System.out.println(box3.l + " " + box3.h + " " + box3.w); // 4.0 5.0 6.0

        // System.out.println(box.weight);// we can't access the variables of child
        // class
        // child can access the variables of parent class, bu if object is directly
        // created of parent class it will not be able to access the child property

        BoxWeight box4 = new BoxWeight();
        System.out.println(box4.l + " " + box4.h + " " + box4.w + " " + box4.weight);
        // -1.0 -1.0 -1.0 -1.0
        BoxWeight box5 = new BoxWeight(2, 3, 4, 5);
        System.out.println(box5.l + " " + box5.h + " " + box5.w + " " + box5.weight);
        // 2.0 3.0 4.0 5.0

        // Type of reference variable determines what members variables will be
        // accessed
        // Here box6 is reference type of Box, hence it can only access member
        // variables
        // of Box class and it will not be able to access member variables of
        // BoxWieght
        // class
        Box box6 = new BoxWeight(2, 3, 4, 9);
        System.out.println(box6.l + " " + box6.h + " " + box6.w + " " + box6.weight);
        // we are unable to access the

        // gives error
        // there are many variables in both parent and child classes, you are given
        // access to variables that are in the reference type ie. BoxWeight
        // hence, you should have access to weight variables
        // this also means, that the ones you are trying to access should be
        // initialied
        // // but here, when the object itself is of type parent class , how will you
        // call
        // the constructor of child class
        // BoxWeight box7 = new Box(1, 2, 3);
        // System.out.println(box5);

        BoxPrice box7 = new BoxPrice(5, 8, 200);

        box1.greeting();
        Box.greeting(); // convention is to access static method via class name

        // we can't override static methods, hence greeting of Box class is called
        Box box8 = new BoxWeight();
        // box8.greeting(); // Hey i am in box class, greetings!
        Box.greeting(); // Hey i am in box class, greetings

        // Boxweight box8 = new BoxWeight();
        // BoxWeight.greeting();// we can inherit but we can't override
    }
}
