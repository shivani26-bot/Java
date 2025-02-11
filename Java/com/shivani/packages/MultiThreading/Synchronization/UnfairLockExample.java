package com.shivani.packages.MultiThreading.Synchronization;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

// public class UnfairLockExample {

//     // here every time we will run , threads will randomly acquire the lock
//     // in lock order should be maintained

//     private final Lock unfairLock = new ReentrantLock();

//     public void accessResource() {
//         unfairLock.lock();
//         try {
//             System.out.println(Thread.currentThread().getName() + " acquired the lock ");
//             Thread.sleep(1000);
//         } catch (InterruptedException e) {
//             Thread.currentThread().interrupt();
//         } finally {
//             unfairLock.unlock();
//             System.out.println(Thread.currentThread().getName() + " released the lock ");
//         }

//     }

//     public static void main(String[] args) {
//         UnfairLockExample example = new UnfairLockExample();

//         Runnable task = new Runnable() {
//             @Override
//             public void run() {
//                 example.accessResource();
//             }
//         };
//         Thread thread1 = new Thread(task, "Thread 1");
//         Thread thread2 = new Thread(task, "Thread 2");
//         Thread thread3 = new Thread(task, "Thread 3");
//         thread1.start();
//         thread2.start();
//         thread3.start();
//     }
// }

public class UnfairLockExample {
    // now we will get the result in the order we will request, which thread will
    // run first will depends on how threads are scheduled
    // fair lock
    // within the thread order will be maintained
    // every thread will get chance -> true
    private final Lock lock = new ReentrantLock(true);

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock ");
        }

    }

    public static void main(String[] args) throws Exception {
        UnfairLockExample example = new UnfairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");
        try {
            thread1.start();
            Thread.sleep(50);
            thread2.start();
            Thread.sleep(50);
            thread3.start();
        } catch (Exception e) {
        }
    }
}

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
