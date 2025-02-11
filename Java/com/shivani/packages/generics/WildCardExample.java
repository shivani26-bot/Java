package com.shivani.packages.generics;

import java.util.*;

// we can add all the classes which are number or subclasses of number
// here T should either be Number or its subclasses ie Integer, Float etc
public class WildCardExample<T extends Number> {

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // working as index value

    public WildCardExample() {
        // this.data = new T[DEFAULT_SIZE];//wrong
        this.data = new Object[DEFAULT_SIZE];
    }

    // public void getList(List<Number> list) {
    // // here we can only pass Number type
    // }

    // wildcard
    public void getList(List<? extends Number> list) {
        // here we can only pass Number type as well as it's subclasses
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }

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
        T removed = (T) (data[--size]);
        return removed;
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

        WildCardExample<Number> list = new WildCardExample<>();
        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }
        System.out.println(list);

    }
}