package com.shivani.packages.MultiThreading.Synchronization;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    // it prevents deadlock
    // it also achieved synchronization
    // when we use ReentrantLock a count is maintained, how many times lock has been
    // acquired
    // lock will be released when it will be matched to it's respective unlock
    // we can enter into the lock again, hence inner method will acquire the lock
    // again because same thread holds it
    // if same thread is running and it has acquired the lock then it can acquire
    // the lock again

    public void outerMethod() {
        lock.lock(); // thread will lock this resource here //1
        // lock.lockInterruptibly();// Acquires the lock unless the current thread is
        // interrupted.
        // Acquires the lock if it is available and returns immediately.
        try {
            System.out.println("outer method");
            innerMethod();
        } finally {
            lock.unlock();// 0
        }
    }

    public void innerMethod() {
        // already we have locked, we are trying to lock again , thread is waiting for
        // it's own to get finished, it's dependent on it's own-> it's called deadlock
        // outermethod is waiting for innerMethod to get finished and vice versa

        lock.lock();// 2
        try {
            System.out.println("inner method");
        } finally {
            lock.unlock(); // 1 lock is still acquired, other thread can't enter
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
