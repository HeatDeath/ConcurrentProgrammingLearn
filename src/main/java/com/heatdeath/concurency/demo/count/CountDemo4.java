package com.heatdeath.concurency.demo.count;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Author:  heatdeath
 * Date:    2018/4/10
 * Desc:    使用 volatile 关键字
 */
@Slf4j
@NotThreadSafe
public class CountDemo4 {
    public static int clientTotal = 5000;
    public static int threadTotal = 200;
    public static volatile int count = 0;

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
        // 5000 次 add（） 操作结束后，shutdown 服务
        countDownLatch.await();
        service.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        count++;
        // 获取 count 的值
        // 对 count 进行 +1 操作
        // 将结果复制给 count
        // volatile 仅仅保证读变量的读写具有原子性，自增操作是复合操作
    }
}
