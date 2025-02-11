package com.shivani.packages.interfaces.annotations;

public interface A {

    // static methods will never get inherited
    // inheritance means we have to override and override requires object and static
    // is independent of objects
    // if we have static method here, we should define it here because they can't be
    // overidden
    // static interface methods should always have a body

    // static void greeting(); //not allowed
    // call via the interface name
    static void greeting() {
        System.out.println("Greetings from a static method!");
    }

    // from java8 onwards we can provide methods as default
    // to provide a way so that interfaces can be expanded without breaking the
    // existing code
    // use when a class is implementing many interfaces that have common methods
    default void fun() {
        System.out.println("I am in A");
    }
    // even though we don't override this method int the Main class it will not give
    // an error
}
