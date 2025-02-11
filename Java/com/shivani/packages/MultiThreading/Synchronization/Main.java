package com.shivani.packages.MultiThreading.Synchronization;

public class Main {
    public static void main(String[] args) {
        // Counter counter = new Counter();
        // // we have shared the same resource or object in two threads
        // MyThread t1 = new MyThread(counter);
        // MyThread t2 = new MyThread(counter);
        // t1.start();
        // t2.start();
        // try {
        // t1.join();
        // t2.join();
        // } catch (Exception e) {
        // }
        // System.out.println(counter.getCount());// we want the final value of count to
        // be 2000 but it doesn't happen
        // both the threads are running simultaneously , hence both will read the same
        // value of count at the same time and increase the count
        // hence if count value is 101 then both the thread will read the same value and
        // increment the counter by 1 and counter vlaue will be increased to 102 , hence
        // we ran two threads but the value was incremented only once. this happens in
        // some cases and due to which we don't get final value as 2000, we are sharing
        // the same object between multiple threads
        // here result depends on relative timing of threads, because threads are
        // running concurrently, hence reult will be unpredictable . this is called race
        // condition

        // hence to solve the above problem, and to make sure at a time only one method
        // accesss the increment() mehtod, if one method is accessing the increment()
        // method then other will wait for it we can use synchronized keyword before the
        // increment() method
        // now we will get 2000 everytime we will run this
        // in order to allow only one thread to access the method at once . this
        // condition is called mutual exclusion

        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // for (int i = 0; i < 10000; i++) {
                bankAccount.withdraw(50);
                // }
            }
        };
        // both the threads are doing same work of withrawing 500 rupees from same bank
        // account
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
        // with intrinsic lock
        // Thread 1 attempting to withdraw 50
        // Thread 1 completed withdrawl. Ramaining balance: 50
        // Thread 2 attempting to withdraw 50
        // Thread 2 proceeding with withdrawl
        // Thread 2 completed withdrawl. Ramaining balance: 0

        // after using extrinsic lock
        // output:
        // Thread 1attempting to withdraw50
        // Thread 2attempting to withdraw50
        // Thread 2 processing withdrawl
        // Thread 1could not acquire the lock , will try later
        // Thread 2 completed withdrawl. Remaining balance: 50

    }
}
