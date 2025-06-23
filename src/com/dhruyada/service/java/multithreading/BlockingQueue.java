package com.dhruyada.service.java.multithreading;


import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.Thread.sleep;

class Producer implements Runnable{

    private ArrayBlockingQueue<Integer> queue;

    public Producer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true){
            try{
//                sleep(500);
                queue.put(BlockingQueue.counter);
                System.out.println("Value added in the queue " + BlockingQueue.counter);
                BlockingQueue.counter++;
            }catch (InterruptedException e){
                System.out.println("Interrupted thread: " + Thread.currentThread().getName());
            }
        }
    }
}

class Consumer implements Runnable{

    private ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true){
            try{
                sleep(1500);
                queue.take();
                System.out.println("Value Removed from the queue " + BlockingQueue.counter);
                BlockingQueue.counter--;
            }catch (InterruptedException e){
                System.out.println("Interrupted thread: " + Thread.currentThread().getName());
            }
        }
    }
}


public class BlockingQueue {
    public static int counter = 1;
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread thread1 = new Thread(new Producer(queue));
        thread1.start();
        Thread thread2 = new Thread(new Consumer(queue));
        thread2.start();
    }
}
