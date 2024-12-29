package org.example;

public class MyThreadR implements Runnable{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+" Started");
        System.out.println(threadName+" Finished");
    }
}
