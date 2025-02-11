package com.shivani.staticExample;

//no need to import human class as both the files main and human lies inside same package or folder
public class Main {
    public static void main(String[] args) {
        Human shivani = new Human(24, "shivani", 100000, false);
        Human shruti = new Human(20, "shruti", 100000, true);

        System.out.println(shivani.name);
        System.out.println(shruti.name);
        // System.out.println(shivani.population); // 1
        // System.out.println(shruti.population); // 1 wrong output population should be
        // 2 for both of them, this error
        // occured because population is declared without static
        System.out.println(shivani.population); // 2
        System.out.println(shruti.population);// 2 when population is declared static

        // greet(); // error because we are accessing non static method inside a
        // static method
        // main()
        // static method only access static data
        greeting();

        Main fun2 = new Main();
        fun2.funn();
    }

    // this is not dependent on objects
    static void fun() {
        // we can't access non static stuff without referencing their instances in a
        // static context
        // hence here i am referncing it
        Main obj = new Main();
        obj.greet(); // object is needed

        // greet(); // error ,without specifying the instance to which greet() method
        // belongs to ,we can't use non static method greet() inside a static method
    }

    // non static method
    // wkt. something which is not static belongs to an objects
    // greet() will have instance but main() method will never have instance
    void greet() {
        fun(); // inside non static method we can use static method
        System.out.println("Hello world");
    }

    void funn() {
        greet();
    }

    static void greeting() {
        System.out.println("Hello world");
    }

}

// properties that are not directly related to objects are static variables
// for ex: population is a property which will be common to all the objects of
// human class
// to all the people popultion of the country will be same, because it's a fact.
// for two different people population will be same
// hence population is independent of objects