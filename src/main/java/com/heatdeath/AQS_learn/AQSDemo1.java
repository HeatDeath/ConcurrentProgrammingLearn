package com.heatdeath.AQS_learn;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author:  heatdeath
 * Date:    2018/4/21
 * Desc:
 */
@Slf4j
public class AQSDemo1 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        for (int i = 10; i < 100; i++)
            set.add(i);
        log.info("set.size = {}", set.size());
        set.forEach(elem -> log.info(elem.toString()));

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put(null, null);
        log.info("{}", map.get(null));
    }
}
