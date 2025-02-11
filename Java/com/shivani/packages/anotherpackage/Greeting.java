package com.shivani.packages.anotherpackage;

import static com.shivani.packages.bpackage.Message.message;

public class Greeting {
    public static void main(String[] args) {
        System.out.println("You are sweet");
        // using the code written in bpackage via anotherpackage
        message();
    }
}

// By default java run time will start from the current directory which we run
// when we specify the path in the import statement then only those item within
// the package that are declared as public only they will be available to the
// files outside the package
// anotherpackage is outside bpackage, hence only public modifiers will be
// available to the files outside the bpackage ie in the anotherpackage only
// public modifiers of bpackage will be available
