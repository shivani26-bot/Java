package com.shivani.staticExample;

// // // outside classes can't be static only inner classes can be static 
// // //error
// static public class InnerClasses {
//     class Test {
//     }

// }

// // objects are created at run time and static methods and variables have to do
// // nothing with objects,hence static methods variables classes are resolved
// // during compile time

public class InnerClasses {
    // every instance of outer class will have class Test as well
    // inner class is dependent on object of outer class,this class doesn't have
    // it's own
    // object
    class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // inside a static method we can't call class which is non static
        Test a = new Test("shruti"); // error
        Test b = new Test("shivani");
    }
}

// correct
// The Test class doensn't depend on any other class
// class Test {
// static String name;

// // same static variable will be changed from shruti to shivani
// public Test(String name) {
// Test.name = name;
// }
// }
// // The provided code does not give an error because your Test class is not a
// // non-static inner class; it is a top-level class.

// // In Java, top-level classes (like Test) can be accessed and instantiated
// from
// // anywhere, including static methods of other classes. The rule about
// // "non-static classes not being accessible in static methods" applies only
// to
// // non-static inner classes.
// public class InnerClasses {
// public static void main(String[] args) {
// // inside a static method we can't call class which is non static
// Test a = new Test("shruti");
// Test b = new Test("shivani");
// System.out.println(a.name + " " + b.name); // shivani shivani
// }

// }

// public class InnerClasses {
// // not dependent on objects of outer class but it is dependent on the class
// // itself
// // when we talk about static context, we talk about where it is mentioned as
// // static, class Test is mentioned as static inside InnerClass and hence it's
// // not dependent on objects of InnerClasses
// // but class Test and main() can have instances of each other
// static class Test {
// String name;

// public Test(String name) {
// this.name = name;
// }

// @Override
// public String toString() {
// return name;
// }
// }

// public static void main(String[] args) {
// Test a = new Test("shruti");
// Test b = new Test("shivani");
// System.out.println(a.name + " " + b.name); // shruti shivani
// System.out.println(a); // without overriding toString() output->
// // com.shivani.staticExample.InnerClasses$Test@6fdb1f78
// System.out.println(a); // after overriding toString() shruti
// }

// }
