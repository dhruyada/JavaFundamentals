package com.dhruyada.service.java.multithreading;

import java.util.concurrent.locks.Lock;

public class ReentrantLock {
    public static int counter = 0;
    static Lock lock = new java.util.concurrent.locks.ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    lock.lock(); // this is costly and should be called outside this lock
                    try {
                        counter++;
                    } finally {
                        lock.unlock();
                    }
                    //what if we don't unlock due to an exception?
//                  hence try catch
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    lock.lock();
                    try {
                        counter++;
                    } finally {
                        lock.unlock();
                    } // to ensure we unlock it :))
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Counter is: " + counter);
    }
}
