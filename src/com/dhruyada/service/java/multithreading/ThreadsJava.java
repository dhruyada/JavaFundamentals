package com.dhruyada.service.java.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SomeThread extends Thread{
    private CountDownLatch latch;
    private String name;
    public SomeThread(CountDownLatch latch, String name){
        super(name);
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Started Thread: " + Thread.currentThread().getName());
        System.out.println("Thread Ended: " + Thread.currentThread().getName());
        System.out.println("*******************************************************");
        latch.countDown();
    }
}

public class ThreadsJava {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        SomeThread thread1 = new SomeThread(latch, "thread1");
        SomeThread thread2 = new SomeThread(latch, "thread2");
        SomeThread thread3 = new SomeThread(latch, "thread3");
        SomeThread thread4 = new SomeThread(latch, "thread4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        latch.await();
        System.out.println("Main thread: " + Thread.currentThread().getName());


        // The above is fine if we have less no. of threads but what happens if we have more
        // threads say 100... what then?


//        ExecutorService executorService = Executors.newFixedThreadPool(6);
//        executorService.execute(thread1);
//        executorService.shutdown(); //once all the thread are done executing
    }


}
