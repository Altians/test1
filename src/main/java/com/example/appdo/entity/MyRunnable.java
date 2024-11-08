package com.example.appdo.entity;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: crh
 * @CreateDate: 2024/6/5
 * @Description:
 */
public class MyRunnable implements Runnable{
    /**
     * 自定义线程名
     */
    private String threadName;

    /**
     * CountDownLatch指令
     */
    private CountDownLatch latch;

    public MyRunnable(String threadName, CountDownLatch latch) {
        this.threadName = threadName;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // 等待 countDownLatch.countDown() 命名
            latch.await();
            System.out.println(threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
