package com.dhruyada.service.java.multithreading;

import static java.lang.Thread.sleep;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        String lock1 = "Lock1";
        String lock2 = "Lock2";
        Thread thread1 = new Thread(()->{
            synchronized (lock1) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread1 here b**ches, lock1");
                synchronized (lock2){
                    System.out.println("Thread1 here b**ches, lock2");

                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (lock2) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread2 here b**ches, lock2");
                synchronized (lock1){
                    System.out.println("Thread2 here b**ches, lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Main Thread here guys :))");
    }
}
