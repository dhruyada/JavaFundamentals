package com.dhruyada.service.java.multithreading;
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
    /**
     * With synchronized this method will only be accessible to a thread
     * when its previous execution is complete
     */
     public void generate() throws InterruptedException {
         synchronized(this){
         for(int i = 0; i<10; i++) {
            Thread.sleep(5);
            System.out.print("[");
        }
        for(int i = 0; i<10; i++) {
            Thread.sleep(5);
            System.out.print("]");
        }
        System.out.println();
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(10);
        }
    }
}

public class ThreadingDemo {
    public static int counter = 0;
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

        //Synchronization Issue
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

        Brackets brackets = new Brackets();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                try {
                    brackets.generate();
                } catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken by thread 1 " + (endTime-startTime));
        }).start();

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                try {
                    brackets.generate();
                } catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken by thread 2 " + (endTime-startTime));
        }).start();

    }
}
