package com.dhruyada.service.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class DeadLock {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            lock1.lock();
            System.out.println("Thread1 here b**ches, lock1");
            lock2.lock();
            System.out.println("Thread1 here b**ches, lock2");
            lock1.unlock();
            lock2.unlock();
        });

        Thread thread2 = new Thread(()->{
            lock2.lock();
            System.out.println("Thread2 here b**ches, lock2");
            lock1.lock();
            System.out.println("Thread2 here b**ches, lock1");
            lock2.unlock();
            lock1.unlock();
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Main Thread here guys :))");
    }
}
