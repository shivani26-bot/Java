package com.shivani.packages.generics;

import java.util.*;
// generics is compile time, hence it will not allow run time declaration this.data = new T[DEFAULT_SIZE];
// the actual object creation happens at run time,bytecode has no idea about T at runtime, at run time bycode is executed 
// we can't create a instance of generic type  this.data = new T[DEFAULT_SIZE];

// class CustomGenArrayList<T> is generic, where T is a type parameter. During compilation, T is replaced with Object due to type erasure.
// This ensures backward compatibility with pre-generic Java but removes type information at runtime. Hence, all internal storage (data) is an Object[] array.
public class CustomGenArrayList<T> {
    // You cannot create an array of a parameterized type (new T[DEFAULT_SIZE])
    // because of type erasure. The JVM doesn’t know the type of T at runtime.
    // Instead, the internal array (data) is declared as Object[]. This works
    // because all types in Java inherit from Object, allowing Object[] to store any
    // type.

    // Since generics lose type information at runtime, using Object[] allows
    // storing any type.
    // Typecasting is required to retrieve elements as their original type (T)
    // because the internal array does not retain type information.
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // working as index value

    public CustomGenArrayList() {
        // this.data = new T[DEFAULT_SIZE];//wrong
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        // The array data is declared as Object[]. Assigning elements to data[size++]
        // does not require casting because Object is a superclass of all types.
        data[size++] = num;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void resize() {
        Object[] temp = new Object[data.length * 2];
        // copy the current items in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i]; // here in the object we are adding new elements
        }
        data = temp;
    }

    public T remove() {
        // To provide type safety, elements are explicitly cast to T when retrieved from
        // the Object[] array.
        // This is allowed because the user specifies the type (T) when creating an
        // instance of CustomGenArrayList, ensuring that all added elements are of type
        // T
        T removed = (T) (data[--size]); // here in smaller type more restrictive type, we are trying to add bigger type
        return removed; // we don't actually delete the data but reducing the size by 1
        // when we will add new element it will over ride the value
        // 3 4 8 1 5 7
        // sz=5 index
        // if we call remove then
        // 3 4 8 1 5 7
        // sz=4 index
        // we we call add then it will override the value of 7

    }

    public T get(int index) {
        return (T) (data[index]);
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        data[index] = value; // in bigger one we are adding smaller one, hence no casting required
    }

    @Override
    public String toString() {
        return "CustomArrayList{" + "data=" + Arrays.toString(data) + ", size=" +
                size + '}';
    }

    public static void main(String[] args) {
        CustomGenArrayList<Integer> list = new CustomGenArrayList<>();
        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }
        System.out.println(list); // CustomArrayList{data=[0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26,
                                  // null, null, null, null, null, null], size=14}

    }

}
