package com.heatdeath.concurency.demo.countDemo;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:  heatdeath
 * Date:    2018/4/10
 * Desc:    使用 Atomic 原子类
 */
@Slf4j
@ThreadSafe
public class CountDemo2 {
    public static int clientTotal = 5000;
    public static int threadTotal = 200;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();

        // 最多同时执行的线程数量为 200
        Semaphore semaphore = new Semaphore(threadTotal);

        // add() 操作一共被调用 5000 次
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        service.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        count.incrementAndGet();
//        count.getAndIncrement();
    }
}
