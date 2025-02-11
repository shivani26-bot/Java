package com.shivani.packages.cloning;

// public class Human {
//     int age;
//     String name;

//     public Human(int age, String name) {
//         this.age = age;
//         this.name = name;
//     }

//     public Human(Human other) {
//         this.age = other.age;
//         this.name = other.name;
//     }

// }
// interface cloneable doesn't have any abstract methods, then why we are implementing the interface 
// we are just telling the jvm that we are using clone() in the object of type human 
// public class Human implements Cloneable {
//     int age;
//     String name;

//     public Human(int age, String name) {
//         this.age = age;
//         this.name = name;
//     }

//     public Human(Human other) {
//         this.age = other.age;
//         this.name = other.name;
//     }

//     @Override
//     public Object clone() throws CloneNotSupportedException {
//         // super->object
//         return super.clone();
//     }
// }

// public class Human implements Cloneable {
//     int age;
//     String name;
//     int[] arr;

//     public Human(int age, String name) {
//         this.age = age;
//         this.name = name;
//         this.arr = new int[] { 3, 4, 5, 6, 9, 1 };
//     }

//     @Override
//     public Object clone() throws CloneNotSupportedException {
//         // super->object
//         // this is shallow copy
//         return super.clone();

//         // for primitive values like age it will create a new copy but for non
//         // primitive like array ,String it will point to same or refer to the one in the
//         // original object
//         // hence the change will be reflected in the clone for the non primitive types

//     }

public class Human implements Cloneable {
    int age;
    String name;
    int[] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[] { 3, 4, 5, 6, 9, 1 };
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // deep copy
        Human twin = (Human) super.clone(); // this is shallow copy, till here twin will be pointing to the same array
                                            // as there in original object

        // make a deep copy
        twin.arr = new int[twin.arr.length]; // creating a new array of cloned object
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;

    }
}