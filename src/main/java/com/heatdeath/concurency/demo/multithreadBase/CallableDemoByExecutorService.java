package com.heatdeath.concurency.demo.multithreadBase;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Author:  HeatDeath
 * Date:    2018/4/10
 * Desc:    ExecutorService + Callable + Future
 */
@Slf4j
public class CallableDemoByExecutorService {

    public static void main(String[] args) throws Exception {
        log.info("main thread id is {}", Thread.currentThread().getId());

        Callable<Long> callableTask = new Task();
        ExecutorService service = Executors.newCachedThreadPool();

        Future<Long> future = service.submit(callableTask);
        service.shutdown();

        Long result = future.get();
        log.info("child thread id is {}", result);
    }
}
