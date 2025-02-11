package com.shivani.packages.cloning;

import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human shivani = new Human(24, "shivani kumari");
        // Human twin = new Human(shivani); // using new keyword takes a lot time

        // create a exact copy of object->object cloning
        // clone() is method in Object class
        // In java there is interface called clonable we must implement that by the
        // class whose clone we want to create

        // it's a shallow copy of object
        // Human twin = (Human) shivani.clone();
        // System.out.println(twin.age + " " + twin.name);
        // System.out.println(Arrays.toString(twin.arr));// [3, 4, 5, 6, 9, 1]
        // twin.name = "shruti";
        // twin.arr[0] = 100;
        // System.out.println(Arrays.toString(shivani.arr)); // [100, 4, 5, 6, 9, 1]
        // System.out.println(shivani.name);// shivani kumari

        // if inside the main object whose copy we are creating there are more objects
        // like String, array then inside the copy of the original object , the value
        // for those object will not be newly created but it will point to these object
        // in the original object

        // deepcopy
        Human twin = (Human) shivani.clone();
        System.out.println(twin.age + " " + twin.name);
        System.out.println(Arrays.toString(twin.arr));// [3, 4, 5, 6, 9, 1]
        twin.name = "shruti";
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(twin.arr)); // [100, 4, 5, 6, 9, 1]
        System.out.println(Arrays.toString(shivani.arr)); // [3, 4, 5, 6, 9, 1]
        System.out.println(shivani.name);// shivani kumari

    }
}

// deep copy
// two differenct objects are created change in any or them will not be
// reflected in the other
// shivani={
// age:24,
// name:"shivani kumari",
// arr:[3,4,5,6,9,1]
// }
// twin={
// age:24,
// name:"shivani kumari",
// arr:[3,4,5,6,9,1]
// }

// shallow copy
// shivani={
// age:24,
// name:"shivani kumari",
// arr:[3,4,5,6,9,1]
// }
// twin={
// age:24,
// name:points to the name in shivani
// arr:points to the arr in shivani
// }
