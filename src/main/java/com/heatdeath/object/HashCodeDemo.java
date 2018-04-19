package com.heatdeath.object;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:  heatdeath
 * Date:    2018/4/19
 * Desc:
 */
@Slf4j
public class HashCodeDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();
        log.info("obj1 hash code is {}", obj1.hashCode());
        log.info("obj1.toString is {}", obj1.toString());
//        Object obj2 = new Object();
        obj1 = new Object();
        log.info("obj2 hash code is {}", obj1.hashCode());
        log.info("obj2.toString is {}", obj1.toString());

        Object obj3 = obj1;
        log.info("obj3 hash code is {}", obj3.hashCode());
        log.info("obj3.toString is {}", obj3.toString());
        log.info("obj3 == obj1 result is {}", obj3==obj1);
        log.info("obj3.equals(obj1) result is {}", obj3.equals(obj1));

    }
}
