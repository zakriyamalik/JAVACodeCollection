package org.example;

public class Main {
    public static void testMyThread()
    {

    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThreadR(), "Personal Thread");
        thread1.setPriority(2);

        Thread thread2 = new Thread(new MyThreadR(), "5C Thread");
        thread2.setPriority(3);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName+" Started");
                testMyThread();
                System.out.println(threadName+" Finished");
            }
        }, "5B Thread");
        thread3.setPriority(1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}