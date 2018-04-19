package com.heatdeath.concurency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author:  heatdeath
 * Date:    2018/4/11
 * Desc:
 */
@Slf4j
public class LockDemo3 {
    private static Map<String, Object> map = new HashMap<>();
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final Lock writeLock = lock.writeLock();
    private static final Lock readLock = lock.readLock();

    public LockDemo3() {
        map.put("key1", "val1");
        map.put("key2", "val2");
    }

    public static Object get(String key) throws Exception {
        readLock.lock();
        try {
            log.info("{}", map.get(key));
            Thread.sleep(30000);
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys() {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public static Object put(String key, Object value) throws Exception {
        writeLock.lock();
        try {
            Thread.sleep(30000);
            return map.put(key, value);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                try {
                    log.info("thread id:{}, get value:{}", Thread.currentThread().getId(), get("key1"));
                } catch (Exception e) {
                    log.error("{}", e);
                }
            });
        }

        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                try {
                    log.info("thread id:{}, get value:{}", Thread.currentThread().getId(), put("key3", Thread.currentThread().getId()));
                } catch (Exception e) {
                    log.error("{}", e);
                }
            });
        }
    }

}
