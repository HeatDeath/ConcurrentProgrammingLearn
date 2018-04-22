package com.heatdeath;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:  heatdeath
 * Date:    2018/4/22
 * Desc:
 */
public class thread_pool_learn {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
