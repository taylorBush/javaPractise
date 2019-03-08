package com.youku.study.thread;

/**
 * @author taylor
 * @date 2019/3/7
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
