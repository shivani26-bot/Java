package com.shivani.packages.properties.polymorphism;

// every class inherits from object class 
// here toString()  method of  object class is implemented bydefault 
public class ObjectPrint {
    int num;

    public ObjectPrint(int num) {
        this.num = num;
    }

    @Override
    // at run time it will decide that this method should run
    public String toString() {
        return "ObjectPrint{" +
                "num=" + num +
                '}';
    }

    public static void main(String[] args) {
        ObjectPrint obj = new ObjectPrint(54);
        System.out.println(obj);
    }
}
