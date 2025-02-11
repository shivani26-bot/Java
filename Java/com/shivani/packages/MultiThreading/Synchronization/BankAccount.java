package com.shivani.packages.MultiThreading.Synchronization;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;

public class BankAccount {

    private int balance = 100;

    // intrinsic lock
    // at a time only 1 thread can access this method
    // if we increase sleep time then thread 2 will barely get chance to perform,
    // thread 1 will perform for longer time and then thread 2 chance will come
    // hence we will use explicit lock
    // each thread 1 and thread 2 will take time equals to sleep time
    // public synchronized void withdraw(int amount) {
    // System.out.println(Thread.currentThread().getName() + " attempting to
    // withdraw " + amount);
    // if (balance >= amount) {
    // System.out.println(Thread.currentThread().getName() + " proceeding with
    // withdrawl ");
    // try {
    // Thread.sleep(10000);
    // } catch (InterruptedException e) {

    // }
    // balance -= amount;
    // System.out
    // .println(Thread.currentThread().getName() + " completed withdrawl. Ramaining
    // balance: " + balance);
    // } else {
    // System.out.println(Thread.currentThread().getName() + " insufficient balance
    // ");
    // }

    // }

    // Lock is a interface and lock is a object of that interface
    // The thread which will acquire the Lock that will access the critical section
    // lock.lock()-> thread tries to acquire the lock , if lock is not available
    // then it will wait
    // lock.trylock()->
    // lock.unlock()-> if a thread runs unlock method then it will release the lock
    // so that other threads can acquire it
    // ReentrantLock is implementation of Lock class

    // now threads will access the withdraw method with help of lock object
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {

        System.out.println(Thread.currentThread().getName() + "attempting to withdraw" + amount);
        try {
            // lock.lock();

            // lock.tryLock()-> Acquires the lock only if it is free at the time of
            // invocation.
            // Acquires the lock if it is available and returns immediately with the value
            // true. If the lock is not available then this method will return immediately
            // with the value false.

            // lock.tryLock(1000, TimeUnit.MILLISECONDS)->Acquires the lock if it is free
            // within the given waiting time and the current thread has not been
            // interrupted.
            // If the lock is available this method returns immediately with the value true.
            // If the lock is not available then the current thread becomes disabled for
            // thread scheduling purposes and lies dormant until one of three things
            // happens:
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " processing withdrawl ");
                        Thread.sleep(3000);// simulate time taken to process the withdrawl
                        balance -= amount;
                        System.out.println(
                                Thread.currentThread().getName() + " completed withdrawl. Remaining balance: "
                                        + balance);
                    }

                    catch (Exception e) {
                        // if we use lock.tryLock(1000, TimeUnit.MILLISECONDS) then it may happen that
                        // interruption can occur , hence that must be handled some where
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock(); // always release the resources in finally block
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance ");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "could not acquire the lock , will try later");
            }

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        // if (Thread.currentThread().isInterrupted()) {
        // // we can perform anything we want here
        // }

    }
}
