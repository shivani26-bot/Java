package com.shivani.packages.access;

public class ObjectDemo {

    int num;
    float gpa;

    public ObjectDemo(int num) {
        this.num = num;

    }

    public ObjectDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    // therse are the methods available in object class which we can override

    // gives the unique number representation of an object
    @Override
    public int hashCode() {
        return super.hashCode();
        // return num;
    }

    @Override
    public boolean equals(Object obj) {
        // return super.equals(obj);
        return this.num == ((ObjectDemo) obj).num; // casting
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // gives the string representation
    @Override
    public String toString() {
        return super.toString();
    }

    // gets called when garbage collection take place
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(98);
        // ObjectDemo obj1 = new ObjectDemo(98);
        ObjectDemo obj1 = obj;
        System.out.println(obj.hashCode()); // 1101288798 SOME RANDOM INTEGER VALUE
        System.out.println(obj1.hashCode()); // 758529971

        ObjectDemo obj2 = new ObjectDemo(98, 56.8f);
        ObjectDemo obj3 = new ObjectDemo(98, 86.8f);
        // java will be confused whether we want to compare num or gpa variable of every
        // object
        // gives error
        // if (obj2 < obj3) {
        // System.out.println("obj1 is less than obj2");
        // }

        // == comparator
        // these two variables are pointing to same object or not
        if (obj2 == obj3) {
            System.out.println("obj1 is equal to obj2");
        }

        // other way to do above
        // .equal() is a method
        // checks whether content of both the objects are similar or not
        if (obj2.equals(obj3)) {
            System.out.println("obj1 is equals to obj2");
        }

        // get the data about the classes we can use getClass().methodname()
        // it's stored in heap area
        System.out.println(obj1.getClass());// class com.shivani.packages.access.ObjectDemo
        System.out.println(obj1.getClass().getName()); // com.shivani.packages.access.ObjectDemo
    }
}
