package com.shivani.packages.Collection;

// public class OurGenericList<T> {
//     // we don't have access to items array outside the class, in order to iterate
//     // over the list we should implement iterable interface

//     private T[] items;
//     private int size = 0;

//     public OurGenericList() {
//         size = 0;
//         items = (T[]) new Object[100];
//     }

//     public void add(T item) {
//         items[size++] = item;
//     }

//     public T getItemAtIndex(int index) {
//         return items[index];
//     }
// }
// Now this class is Iterable we can use for loop to iterate over this class or object of this class sequentially 

import java.util.Iterator;

public class OurGenericList<T> implements Iterable<T> {
    // we don't have access to items array outside the class, in order to iterate
    // over the list we should implement iterable interface

    private T[] items;
    private int size = 0;

    public OurGenericList() {
        size = 0;
        items = (T[]) new Object[100];
    }

    public void add(T item) {
        items[size++] = item;
    }

    public T getItemAtIndex(int index) {
        return items[index];
    }

    @Override
    // returns an iterator so that user can use it to iterate over the list
    public Iterator<T> iterator() {
        // return object of this class
        return new OurGenericListIterator(this);
    }

    private class OurGenericListIterator implements Iterator<T> {
        private OurGenericList<T> list;
        private int index = 0;

        public OurGenericListIterator(OurGenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return index < list.size;
        }

        @Override
        public T next() {
            return list.items[index++];
        }

    }
}

// collection interface extends the iterable interface because collection
// interface wants all the classes implementing collection interface to actually
// implements the methods of iterable interface, because collection is iterable

// Map is not extending colleciton hence it's not iterable