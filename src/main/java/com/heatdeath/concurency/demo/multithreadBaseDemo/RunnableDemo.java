package com.heatdeath.concurency.demo.multithreadBaseDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:  yangyingqian
 * Date:    2018/4/10
 * Desc:
 */
@Slf4j
public class RunnableDemo {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread thread = new Thread(runnable);
        thread.start();

        log.info("main thread ID is {}", Thread.currentThread().getId());

        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}

@Slf4j
class RunnableImpl implements Runnable {
    @Override
    public void run() {
        log.info("an easy Runnable Demo~");
        log.info("child thread ID is {}", Thread.currentThread().getId());
    }
}
