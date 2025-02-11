package com.shivani.packages.MultiThreading.ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 2 threads are used to perform task
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(() -> 1 + 2);// callable is called
        Integer i = future.get();
        System.out.println("sum is " + i); // sum is 3
        executorService.shutdown();
        // System.out.println(executorService.isTerminated()); //false
        Thread.sleep(1);
        System.out.println(executorService.isTerminated()); // true
    }
}

// submit(r)
// submit(c)
// submit(r, ret)
// shutdown()
// shutdownnow()
// awaitTermination()
// isShutdown()
// isTerminate():returns true if all work is completed after shutdown
// invokeAll()
// invokeAny()