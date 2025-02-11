package com.shivani.packages.MultiThreading.ExecutorFramework;

import java.util.concurrent.*;

public class Main {
    // public static void main(String[] args) {
    // long startTime = System.currentTimeMillis();// how many miliseconds passed
    // since 1 jan 1970

    // for (int i = 0; i < 10; i++) {
    // System.out.println(factorial(i));
    // }
    // System.out.println("total time: " + (System.currentTimeMillis() -
    // startTime));
    // }

    // things happen synchronously we take 9 seconds
    // output:
    // 1
    // 1
    // 2
    // 6
    // 24
    // 120
    // 720
    // 5040
    // 40320
    // 362880
    // total time: 10143

    // now analyze time taken while multithreading
    // output :
    // total time: 12
    // 1
    // 362880
    // 40320
    // 5040
    // 720
    // 120
    // 2
    // 24
    // 6
    // main thread
    // public static void main(String[] args) {
    // long startTime = System.currentTimeMillis();// how many miliseconds passed
    // since 1 jan 1970
    // // thread will be running in background
    // for (int i = 1; i < 10; i++) {
    // int finalI = i;// for every lambda expression correct value will be captured
    // Thread thread = new Thread(
    // () -> {
    // // variable used in lambda expression should be final
    // long result = factorial(finalI);
    // System.out.println(result);
    // });
    // thread.start();
    // }

    // // it's a part of main thread it will be printed first, we didn't wait for
    // any
    // // thread to finish earlier, hence give wrong result
    // System.out.println("total time: " + (System.currentTimeMillis() -
    // startTime));
    // }

    // public static void main(String[] args) {
    // long startTime = System.currentTimeMillis();// how many miliseconds passed
    // since 1 jan 1970
    // // thread will be running in background
    // // 9 threads are created here, we are not resusing them
    // Thread[] threads = new Thread[9];
    // for (int i = 1; i < 10; i++) {
    // int finalI = i;// for every lambda expression correct value will be captured
    // threads[i - 1] = new Thread(
    // () -> {
    // // variable used in lambda expression should be final
    // long result = factorial(finalI);
    // System.out.println(result);
    // });
    // threads[i - 1].start();
    // }
    // // wait for all threads to finish
    // for (Thread thread : threads) {
    // try {
    // thread.join();
    // } catch (InterruptedException e) {
    // Thread.currentThread().interrupt();
    // }
    // }
    // // it's a part of main thread it will be printed first, we did wait for all
    // // thread to finish earlier, hence give correct result, time is saved using
    // // multithreading, only 1 sec is required
    // System.out.println("total time: " + (System.currentTimeMillis() -
    // startTime));
    // // output:
    // // 120
    // // 2
    // // 720
    // // 5040
    // // 1
    // // 362880
    // // 24
    // // 40320
    // // 6
    // // total time: 1052
    // }

    // here we are creating threads , writing logic to run the program of factorial,
    // hence we can use executor framework to ease our work, creating threads is
    // done by executor framework, we only have to write buisiness logic, here we
    // can resuse thread as well in executor framework

    // public static void main(String[] args) {
    // long startTime = System.currentTimeMillis();// how many miliseconds passed
    // since 1 jan 1970
    // // create a thread pool
    // // executor is a utility class with different methods
    // // thread pool of 3 threads, every thread will take 3 numbers at a time and
    // // there are total 9 numbers
    // // we can reuse the same thread to calculate factorial of different numbers
    // // if we want to increase the time we can increase the thread number
    // ExecutorService executor = Executors.newFixedThreadPool(3);

    // for (int i = 1; i < 10; i++) {
    // int finalI = i;// for every lambda expression correct value will be captured
    // // .submit method takes a runnable
    // // using submit() we can also return some value
    // executor.submit(() -> {
    // // variable used in lambda expression should be final
    // long result = factorial(finalI);
    // System.out.println(result);
    // });

    // }
    // // main thread doesn't wait for executor to complete and shutdown it will
    // first
    // // print the total time and behind the scenes threads will perform their task
    // executor.shutdown();// after this we can't submit other tasks, gives
    // exception we submit other task
    // // executor.submit(()->{
    // // System.out.println("hii");
    // // }); //gives exception

    // // if we want to perform print method only after all the threads are
    // completed

    // try {
    // // blocks until all tasks have completed execution after shutdown request, or
    // // the timeout occurs or the current thread is interrupted
    // // wait for 100 seconds, if all tasks are not completed then move forward to
    // // execute next statement
    // executor.awaitTermination(100, TimeUnit.SECONDS);
    // } catch (InterruptedException e) {
    // throw new RuntimeException(e);
    // }

    // System.out.println("total time: " + (System.currentTimeMillis() -
    // startTime));
    // // before awaitTermination
    // // output :total time: 21
    // // 6
    // // 1
    // // 2
    // // 720
    // // 120
    // // 24
    // // 362880
    // // 40320
    // // 5040
    // // after awaitTermination
    // // 6
    // // 1
    // // 2
    // // 120
    // // 24
    // // 720
    // // 5040
    // // 362880
    // // 40320
    // // total time: 3071

    // }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Runnable runnable=()-> "hello"; //this gives error
        // Runnable runnable = () -> System.out.println("hello"); // this is correcct
        Callable<String> callable = () -> "hello"; // this is correct
        // Future<Integer> future = executorService.submit(() -> 42);
        // Future<?> future1 = executorService.submit(() -> "Hello"); // bydefault it
        // calls callable method of submit
        Future<?> future1 = executorService.submit(callable);
        Future<String> submit = executorService.submit(() -> System.out.println("hello"), "success");// hello
        // System.out.println("Hello"));// now automatically runnable
        // method of submit is about completion track and other things,
        // called, here future contains status
        // .submit() has 3 methods:
        // submit(Callable<T> task)
        // submit(Runnable task, T result)
        // submit(Runnable task)
        // Runnable has only one method that doesn't return anything
        // callable has only one method that does return a value

        // System.out.println("hello")); // ? indicates any datatype
        // System.out.println(future.get());//42
        System.out.println(future1.get());// hello .get() methods waits for task to
        // complete
        System.out.println(submit.get()); // success
        // output:42
        // Task is done !
        // if (future.isDone()) {
        // System.out.println("Task is done !");
        // }
        executorService.shutdown();

    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
