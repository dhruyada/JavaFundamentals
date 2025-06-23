package com.dhruyada.service.java.multithreading;
import com.sun.tools.javac.Main;

import static java.lang.Thread.sleep;

class MyCounter implements Runnable {
    private int threadNo;

    public MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread no: " + threadNo + " and iteration no: " + i);
        }
    }
}


class Brackets {
    private Object lock = "Lock";
    /**
     * With synchronized this method will only be accessible to a thread
     * when its previous execution is complete
     */
    static synchronized public void generate() throws InterruptedException {
         for(int i = 0; i<10; i++) {
            Thread.sleep(5);
            System.out.print("[");
        }
        for(int i = 0; i<10; i++) {
            Thread.sleep(5);
            System.out.print("]");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(10);
        }
    }
}

public class ThreadingDemo {
    public static int counter1 = 0;
    public static int counter2 = 0;
    volatile public static int flag = 0;
    public static int balance = 0;

    public synchronized void withDraw(int amount) {
        if(balance<=0){
            System.out.println("Waiting for amount to be updated");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Withdraw interrupted ");
                return;
            }
        }
        if(balance-amount < 0){
            System.out.println("Balance too low!!");
            return;
        }
        balance = balance - amount;
        System.out.println("Current Balance " + balance);
    }

    synchronized public boolean deposit(int amount){
        if(amount>0){
            System.out.println("Depositing amount in the bank");
            balance = balance + amount;
            notify(); //notifies the longest waiting thread but notifyAll will start all waiting
            System.out.println("Notified");
            return true;
        }else {
            System.out.println("Invalid amount");
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //We could directly extend thread but we won't be able to extend anything else
        // so we implement runnable and then
//        Thread thread1 = new Thread(new MyCounter(1));
//        Thread thread2 = new Thread(new MyCounter(2));
//        Thread thread3 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Thread no: " + 3 + " and iteration no: " + i);
//            }
//        });
//        thread1.start();
//        thread2.start();
//        thread3.start();

        /**
         * Synchronization Issue
         */
//        new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                counter++;
//            }
//            System.out.println("this loop is over");
//        }).start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                counter++;
//            }
//            System.out.println("this loop is over too");
//        }).start();
//
//        System.out.println("Counter is " + counter);
//        /**
//         * Output is
//         * Counter is 11995
//         * this loop is over too
//         * this loop is over
//          */
        /**
         * Static Synchronization case
         */
//        Brackets brackets1 = new Brackets();
//        Brackets brackets2 = new Brackets();
//
//        new Thread(() -> {
//            long startTime = System.currentTimeMillis();
//            for (int i = 0; i < 5; i++) {
//                try {
//                    brackets1.generate();
//                } catch (InterruptedException e) {
//                    System.out.println(e.getStackTrace());
//                }
//            }
//            long endTime = System.currentTimeMillis();
//            System.out.println("Time taken by thread 1 " + (endTime-startTime));
//        }).start();
//
//        new Thread(() -> {
//            long startTime = System.currentTimeMillis();
//            for (int i = 0; i < 5; i++) {
//                try {
//                    brackets2.generate();
//                } catch (InterruptedException e) {
//                    System.out.println(e.getStackTrace());
//                }
//            }
//            long endTime = System.currentTimeMillis();
//            System.out.println("Time taken by thread 2 " + (endTime-startTime));
//        }).start();
        /**
         * Volatile Keyword
         */
//        new Thread(()->{
//            int i=0;
//            while(true){
//                if(flag==0){
//                    System.out.println(i + " : Running...");
//                    i++;
//                }else{
//                    break;
//                }
//            }
//        }).start();
//        new Thread(()->{
//            try{
//                Thread.sleep(1000);
//                flag = 1;
//                System.out.println("The value of flag updated and thread 1 stopped");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//        }).start();

        /**
         * Wait & Notify
         */

//        ThreadingDemo main = new ThreadingDemo();
//        Thread thread1 = new Thread(() -> {
//            main.withDraw(2000);
//
//        });
//        thread1.setName("Thread 1");
//        thread1.start();
//
//        Thread thread2 = new Thread(() -> {
//            try {
//                sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if(main.deposit(0)){
//                System.out.println("Transaction Completed");
//            }else{
//                thread1.interrupt();  // Sets an internal "interrupted" flag on that thread
//                // If the thread is blocked (e.g., sleeping, waiting, or joining), it throws an InterruptedException and clears the flag.
////                if (Thread.currentThread().isInterrupted()) {
////                      respond to interruption
////                }
//
////                this will be interrupted if there was interruption
////                public void run() {
////                    while (!Thread.currentThread().isInterrupted()) {
////                        // Do some work
////                    }
////                    System.out.println("Thread was interrupted");
////                }
//            }
//        });
//        thread2.setName("Thread 2");
//        thread2.start();


        /**
         * Thread Join
         */
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                try {
                    sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter1++;
            }
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                try {
                    sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter2++;
            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            try {
//                thread1.join(); //first this waiting for thread 1 to complete
                thread2.join(); //then this waiting for thread 2 to complete
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Counter1: " + counter1);
            System.out.println("Counter2: " + counter2);
        });
        thread3.start();

        System.out.println("Main Thread!! " + Thread.currentThread().getName());

    }
}
