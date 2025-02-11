package com.shivani.packages.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // imperative approach , old
        int[] arr = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        // streams , declarative, more readable , consice
        int[] arr2 = { 1, 2, 3, 4, 5 };
        // int sum2 = Arrays.stream(arr2).filter(n -> n % 2 == 0);

        List<String> list = Arrays.asList("apple", "banana", "cherry");
        Stream<String> myStream = list.stream();// converts list to stream

        String[] array = { "apple", "banana", "cherry" };
        Stream<String> stream = Arrays.stream(array);// converts arrays to stream

        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        // Stream.iterate(0, n -> n + 1); // creates infinite stream
        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(100);// creates stream from 0 to 100

        Stream.generate(() -> "Hello").limit(5);// stream of 5 hello

        // stream operations
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 4522, 9, 0, 44, 33, 23, 78, 433, 23, 79, 98, 92, 36);
        // Stream<Integer> int_stream = list1.stream().filter(x -> x % 2 == 0);//creates
        // a stream
        // List<Integer> filteredList = list1.stream().filter(x -> x % 2 ==
        // 0).collect(Collectors.toList()); // convert the
        // // streams to
        // // list
        // System.out.println(filteredList);// [2, 4, 6, 4522, 0, 44, 78, 98, 92, 36]
        // // a stream
        // List<Integer> mappedList = filteredList.stream().map(x -> x /
        // 2).collect(Collectors.toList()); // convert the
        // // streams to
        // // list
        // System.out.println(mappedList);// [1, 2, 3, 2261, 0, 22, 39, 49, 46, 18]
        List<Integer> filteredList = list1.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x / 2)
                .distinct()
                .sorted((a, b) -> (b - a))
                .limit(4) // how many elements from starting of the array
                .skip(1) // how many elements to skip from start of the array
                .collect(Collectors.toList());
        System.out.println(filteredList);// [49, 46, 39]

        List<Integer> collect = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .skip(1)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 10)
                .distinct()
                .sorted()
                .peek(x -> System.out.println("x= " + x))
                .collect(Collectors.toList());
        // System.out.println(collect);
        Integer integer = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .skip(1)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 10)
                .distinct()
                .max((a, b) -> b - a)// sort in descendng order
                .get();
        System.out.println(integer);
        Long integer1 = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .skip(1)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 10)
                .distinct()
                .count();
        System.out.println(integer1);
        // terminal operations: min, max, count,collect , these are performed at the end
        // of the streams

        // Parallelstreams, same as streams, but it divides the large list into chunks,
        // and thread is assigned to each chunk
        // only use if there is large lists, don't use on small list
        List<Integer> li = Arrays.asList(1, 2, 3, 3, 4);
        list.parallelStream();
    }
}

// we can convert collections to stream and apply declarative and functional
// approach
// it means in order to use map , filter, reduce etc methods on collection we
// have to convert them into stream
// declarative means to tell what we want to do , doesn't bother about what ot
// do
// to perform any operation on collection convert it to streams
// sequence of elements or data retrieved from a collection - streams

// distinct(),sorted(),limit(),skip(),min(),max(),count()