package com.heatdeath.concurency.demo.deadLock;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:  heatdeath
 * Date:    2018/4/11
 * Desc:    一个简单的死锁的例子，td1 和 td2 分别在持有 lockA 和 lockB 的同时，
 *          因为一直在试图获取对方持有的锁，从而导致死锁的产生
 */
@Slf4j
public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLockTask td1 = new DeadLockTask(0);
        DeadLockTask td2 = new DeadLockTask(1);
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        //td2的run()可能在td1的run()之前运行
        new Thread(td1).start();
        new Thread(td2).start();
    }
}

@Slf4j
class DeadLockTask implements Runnable {
    public int flag;

    // 静态对象是类的所有对象共享的
    private static Object lock1 = new Object(), lock2 = new Object();

    public DeadLockTask(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        log.info("flag:{}", flag);
        if (flag == 1) {
            synchronized (lock1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    log.info("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (lock2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    log.info("0");
                }
            }
        }
    }

}
