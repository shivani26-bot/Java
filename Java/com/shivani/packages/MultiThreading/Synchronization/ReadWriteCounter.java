package com.shivani.packages.MultiThreading.Synchronization;

import java.util.concurrent.locks.*;
import java.lang.Thread;
// using synchronized keyword:
// we don't have gurantee for
// fairness
// indefinite blocking
// no interruptability
// read/write locking-> synchronized doesn't recognize or differentate between
// read and write, hence it
// will block all the threads and creates unecessary blocking but if we lock
// manually we can overcome this disadvantage

// allows multiple threads to read resources concurrently as long as no thread
// is writing to it, it ensures exclusive access for write operations

public class ReadWriteCounter {

    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    // Returns the lock used for reading
    // readLock();

    // Returns the lock used for writing.
    // writeLock();

    public void increment() {
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        // multiple threads can acquire readLock, threads can acquire readLock only if
        // writeLock is not acquired by another thread
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());

                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented ");

                }
            }
        };

        // which thread will run first depends on how cpu will schedule the threads

        Thread writerThread = new Thread(writeTask);// this thread will perform write task
        // this thread will perform read task
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        // waiting for write and read thread to end
        writerThread.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
