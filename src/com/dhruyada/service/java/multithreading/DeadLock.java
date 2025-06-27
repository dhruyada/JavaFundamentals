//package com.dhruyada.service.java.multithreading;
//
//import java.sql.Time;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//import static java.lang.Thread.sleep;
//
//public class DeadLock {
//    static Lock lock1 = new ReentrantLock();
//    static Lock lock2 = new ReentrantLock();
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(()->{
//            boolean flaglock01 = false;
//            boolean flaglock02 = false;
//
//            while(true){
//                try {
//                    flaglock01 = lock1.tryLock(10, TimeUnit.MICROSECONDS);                flaglock02 = lock1.tryLock(10, TimeUnit.MICROSECONDS);
//                    flaglock02 = lock2.tryLock(10, TimeUnit.MICROSECONDS);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }finally {
//                    if (flaglock01){
//                        System.out.println("Thread1 here b**ches, lock1");
//                        lock1.unlock();
//                    }
//                    if (flaglock02){
//                        System.out.println("Thread1 here b**ches, lock2");
//                        lock2.unlock();
//                    }
//                    if(flaglock01 && flaglock02){
//                        break;
//                    }
//                }
//            }
//
////            lock1.lock();
////            System.out.println("Thread1 here b**ches, lock1");
////            lock2.lock();
////            System.out.println("Thread1 here b**ches, lock2");
////            lock1.unlock();
////            lock2.unlock();
//        });
//
//        Thread thread2 = new Thread(()->{
//            boolean flaglock01 = false;
//            boolean flaglock02 = false;
//
//            while(true){
//                try {
//                    flaglock01 = lock1.tryLock(10, TimeUnit.MICROSECONDS);                flaglock02 = lock1.tryLock(10, TimeUnit.MICROSECONDS);
//                    flaglock02 = lock2.tryLock(10, TimeUnit.MICROSECONDS);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }finally {
//                    if (flaglock02){
//                        System.out.println("Thread2 here b**ches, lock2");
//                        lock2.unlock();
//                    }
//                    if (flaglock01){
//                        System.out.println("Thread2 here b**ches, lock1");
//                        lock1.unlock();
//                    }
//                    if(flaglock01 && flaglock02){
//                        break;
//                    }
//                }
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println("Main Thread here guys :))");
//    }
//}
