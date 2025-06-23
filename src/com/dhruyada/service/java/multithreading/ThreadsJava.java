package com.dhruyada.service.java.multithreading;

class SomeThread extends Thread{
    private String name;
    public SomeThread(String name){
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Started Thread: " + name);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Thread: " + name);
        }
        System.out.println("Thread Ended: " + name);
    }
}

public class ThreadsJava {
    public static void main(String[] args) {
        SomeThread thread01 = new SomeThread("Thread01");
        thread01.start();
    }
    // The above is fine if we have less no. of threads but what happens if we have more
    // threads say 100... what then?
    
}
