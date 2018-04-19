package com.heatdeath.concurency.demo.count;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Author:  heatdeath
 * Date:    2018/4/10
 * Desc:    使用 synchronized 关键字
 */
@Slf4j
@ThreadSafe
public class CountDemo3 {
    public static int clientTotal = 5000;
    public static int threadTotal = 200;
    public static int count = 0;

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

    private static synchronized void add() {
        count++;
    }
}
