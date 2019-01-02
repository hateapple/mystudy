package com.hateapple.controller;

import java.util.concurrent.locks.ReentrantLock;

public class MyTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(new MyRunner(lock, 30000000L));
        Thread t2 = new Thread(new MyRunner(lock, 5000L));
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}
class MyRunner implements Runnable{
    private ReentrantLock lock;
    private Long st;
    MyRunner(ReentrantLock lock, Long st){
        this.lock = lock;
        this.st = st;
    }
    public void run() {
        try{
            this.lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到锁啦，准备睡觉");
            try {
                Thread.sleep(st);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "睡醒啦");

        }finally {
            this.lock.unlock();
            System.out.println(Thread.currentThread().getName() + "解锁成功");

        }

    }
}