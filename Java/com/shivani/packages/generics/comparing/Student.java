package com.shivani.packages.generics.comparing;

// comparable is interface of generic type , see the internal implementation
// compare student with student type 
public class Student implements Comparable<Student> {
    int rollno;
    float marks;

    public Student(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return marks + " ";
    }

    @Override
    public int compareTo(Student o) {
        System.out.println("in comparet to method");
        int diff = (int) (this.marks - o.marks);

        // if diff==0 means both are equal
        // if diff<0: means o is bigger else o is smaller
        return diff;
    }
}
