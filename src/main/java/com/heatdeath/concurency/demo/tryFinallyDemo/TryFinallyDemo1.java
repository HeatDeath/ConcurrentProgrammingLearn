package com.heatdeath.concurency.demo.tryFinallyDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.reflect.Method;

/**
 * Author:  heatdeath
 * Date:    2018/4/14
 * Desc:
 */
@Slf4j
public class TryFinallyDemo1 {
    @Scheduled
    public static void main(String[] args) throws Exception {

        Method method = TryFinallyDemo1.class.getDeclaredMethod("methodDemo");
        log.info(methodDemo());
    }

    private static String methodDemo() {
        try {
//            int i = 1 / 0;
            System.exit(0);
            return "try return";
        } catch (Exception e) {
//            return "catch return";
        }
        return "method return";
    }

}
