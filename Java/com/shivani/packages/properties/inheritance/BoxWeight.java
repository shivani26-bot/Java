package com.shivani.packages.properties.inheritance;

public class BoxWeight extends Box {
    double weight;

    public BoxWeight() {
        this.weight = -1;
        // subclass can't access those members of parent class that are declared as
        // private
        // this.l = 2; // we can't access if l is declared as private in parent class
    }

    // @Override // we can't override static methods
    // but static methods can be inherited
    // overriding depends on object, static doesn't depend on object, hence we can't
    // override static methods, because in order to override we need objects, but
    // static eliminates all the objects

    // static void greeting() {
    // System.out.println("Hey i am in box weight class, greetings!");
    // }

    BoxWeight(BoxWeight other) {
        super(other); // pointing to Box(Box old) {} constructor of parent class
        // it's similar to Box old= new BoxWeight()
        // we are passing object of BoxWeight type and copy constructor is taking Box
        // type, BoxWeight has access to all the variables of Box type because BoxWeight
        // is inherited from Box
        // internally: Box old= other
        // Type of reference variable decides what all variables can be accessed
        weight = other.weight;
    }

    BoxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public BoxWeight(double l, double w, double h, double weight) {
        // if super is not used inside subclass constructor then default constructor of
        // super class will be called Box()
        // super should be used inside subclass constructor
        // directly above BoxWeight is Box class, hence super here points to Box class
        super(l, h, w); // what is this? call the parent class constructor
        // super is used to initialise values present in parent class

        // we can also use super keyword as this keyword, it will be used to access
        // the super class keywords
        System.out.println(this.weight); // points to weight variable in Boxweight class
        System.out.println(super.weight); // points to weight variable in Box class
        System.out.println("h" + " " + this.h);
        this.weight = weight;

        // below two statements give error collectively
        // this.weight = weight;
        // super(l, w, h);
        // super class doesn't care what child class contain ie Box class doesn't care
        // about BoxWeight class but child class cares about what parent class contains
        // hence parent class should be initialized first using super(l,w,h) and then
        // child class should be initialized
    }
}
