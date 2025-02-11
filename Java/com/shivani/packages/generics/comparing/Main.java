package com.shivani.packages.generics.comparing;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student shivani = new Student(12, 87.98f);
        Student shruti = new Student(5, 99.78f);
        Student shivam = new Student(11, 90.78f);
        Student aadya = new Student(13, 79.78f);
        Student rohan = new Student(7, 80.78f);
        Student[] list = { shivani, shruti, shivam, aadya, rohan };
        // here java gets confused based on which parameter to compare the objects
        System.out.println(Arrays.toString(list));
        // Arrays.sort(list); // sort by marks because in compareTo we have added marks
        // but if we remove
        // compareTo method and comparable then it gives error

        // we can also do it like this , becase sort method internally have comparator
        // parameter
        // Arrays.sort(list, new Comparator<Student>() {
        // @Override
        // public int compare(Student s1, Student s2) {
        // return (int) (s1.marks - s2.marks);// ascending order
        // // return -(int) (s1.marks - s2.marks);//descending order
        // }
        // });

        // we can use lambda expression to write the above sort function in simple
        // manner
        Arrays.sort(list, (o1, o2) -> -(int) (o1.marks - o2.marks));
        System.out.println(Arrays.toString(list));

        // if (shivani < shruti) { // error
        // System.out.println("shivani marks is less than shruti");
        // }

        // hence implement comparable to solve this problem
        if (shivani.compareTo(shruti) < 0) {
            System.out.println(shivani.compareTo(shruti)); // -11
            System.out.println("shivani marks is less than shruti");
        }
    }
}
