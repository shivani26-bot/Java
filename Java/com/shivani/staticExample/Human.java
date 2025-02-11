package com.shivani.staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    // long population;
    // declare the variable as static when it's common to all the objects of a class
    static int population = 0;

    static void message() {
        System.out.println("I am human");
        // System.out.println(this.age); // error, because static method is independent
        // of objects of human class hence we can't use something which is dependent on
        // objects, this.age
    }

    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        // to access static variables just use class name, because it's common to all
        // the objects
        // when a member is declared static it can be accessed before any of the object
        // of class being created and without referncing to that object
        // we can declare variables , methods as static
        // static method and variables belong to class and not objects
        Human.population += 1;

        Human.message();
    }

}

// why main() is declared as static in public static void main(String[] args)?
// we can use the method without creating object of that class
// if we don't put main() method as static then in order to run anything inside
// the class we need to create the object for that class
// main() is the entry point of the java program, we should be able to run the
// main() without creating any object of the class in which main() is present