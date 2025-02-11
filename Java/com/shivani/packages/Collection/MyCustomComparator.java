package com.shivani.packages.Collection;

import java.util.Comparator;

public class MyCustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; // descending order
    }
}

// public class MyCustomComparator implements Comparator<MyCustomClass> {
// @Override
// public int compare(MyCustomClass o1, MyCustomClass o2) {
// return o2.getField1() - o1.getField2(); // descending order
// }
// }
