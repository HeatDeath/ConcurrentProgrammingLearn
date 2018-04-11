package com.heatdeath.concurency.demo.multithreadBaseDemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author:  yangyingqian
 * Date:    2018/4/10
 * Desc:
 */
@Slf4j
public class CallableDemoByThread {
    public static void main(String[] args) throws Exception {
        Callable<Long> callable = new Task();
        FutureTask<Long> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        Long result = futureTask.get();
        log.info("child thread id is {}", result);
    }
}

@Slf4j
class Task implements Callable<Long> {
    @Override
    public Long call() {
        return Thread.currentThread().getId();
    }
}
