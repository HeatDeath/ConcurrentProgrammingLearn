package com.heatdeath.concurency.demo.multithreadBaseDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:  yangyingqian
 * Date:    2018/4/10
 * Desc:
 */
@Slf4j
public class ThreadDemo {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();

        log.info("main thread ID is {}", Thread.currentThread().getId());
    }
}

@Slf4j
class TestThread extends Thread {
    @Override
    public void run() {
        log.info("an easy Runnable Demo~");
        log.info("child thread ID is {}", Thread.currentThread().getId());
    }
}
