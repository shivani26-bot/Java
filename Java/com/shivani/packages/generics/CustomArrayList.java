package com.shivani.packages.generics;

import java.util.*;

// promblem here is bydefault we are storing int array internally, but it's not true, we can create array of any data type 
// this problem here is solved using generics , it helps us to provide different datatypes to our custom classes 
public class CustomArrayList {
    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // working as index value

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void resize() {
        int[] temp = new int[data.length * 2];
        // copy the current items in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int remove() {
        int removed = data[--size];
        return removed; // we don't actually delete the data but reducing the size by 1
        // when we will add new element it will over ride the value
        // 3 4 8 1 5 7
        // sz=5 index
        // if we call remove then
        // 3 4 8 1 5 7
        // sz=4 index
        // we we call add then it will override the value of 7

    }

    public int get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" + "data=" + Arrays.toString(data) + ", size=" +
                size + '}';
    }

    public static void main(String[] args) {
        // methods provided by java Arraylist
        // ArrayList list = new ArrayList();
        // list.add(10); //element
        // list.remove(0); //index
        // list.get(0); //index
        // list.set(1, 2342); //index , element
        // list.size();
        // list.isEmpty();

        // internal working of arraylist:
        // when we add elements in arraylist and when it gets full, the size gets double
        // internally, copies all the previous item in the new array and insert the new
        // element
        // taking constant time on an average
        // internally we will use array which is not accessible directly but via getters
        // and setters they are accessible

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("adfasdf");

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7698);

        CustomArrayList list = new CustomArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list); // CustomArrayList{data=[10, 20, 30, 0, 0, 0, 0, 0, 0, 0], size=3}
        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }
        System.out.println(list); // CustomArrayList{data=[10, 20, 30, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22,
                                  // 24, 26, 0, 0, 0], size=17}

    }
}
