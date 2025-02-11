package com.shivani.packages.MultiThreading.ExecutorFramework;

import java.util.concurrent.Callable;

public class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(10);// no need to handle in try catch as it throws exception
        return 1;
    }

}
// in runnable run() method is overrided and in callable call() method is
// overrided
// runnable doesn't throws exception but callable throws exception
