package com.shivani.packages.MultiThreading.ThreadCommunication;

// producer is consuming and then notifying Consumer

// consumer is consuming and then notifying producer 
// producer will produce data , consumer will consume data 
// here we are putting lock on object of shared resource 
// as we run notify,other threads waiting on same shared resource to access lock, are allowed to acquire lock 

// one producer multiple consumer -> use notifyall 
class SharedResource {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);

        notify(); /// notify other thread to consume
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();// notify producer thread to produce data
        return data;
    }
}

// producer will not produce if we have data in buffer
// producer should produce data but if hasData is true then it should wait
// this thread produces data
class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            resource.produce(i);

        }
    }
}

// consumes data when hasData is true or buffer has data
// this thread consumes data
class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            int value = resource.consume();

        }

    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));
        producerThread.start();
        consumerThread.start();
    }
}
