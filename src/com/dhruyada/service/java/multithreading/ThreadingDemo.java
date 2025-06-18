package com.dhruyada.service.java.multithreading;


import static java.lang.Thread.sleep;

class MyCounter extends Thread{
    private int threadNo;

    public MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void countMe() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            sleep(500);
            System.out.println("Thread no: " + threadNo + " and iteration no: " + i);
        }
    }
    
}

public class ThreadingDemo {
    public static void main(String[] args) throws InterruptedException {
        MyCounter counter1 = new MyCounter(1);
        MyCounter counter2 = new MyCounter(2);
        MyCounter counter3 = new MyCounter(2);

        long startTime = System.currentTimeMillis();
        counter1.start();
        System.out.println("======================================");
        counter2.start();
        counter3.start();
        sleep(6000);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Required: " + (endTime - startTime));
    }
}
