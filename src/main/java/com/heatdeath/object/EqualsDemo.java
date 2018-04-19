package com.heatdeath.object;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Author:  heatdeath
 * Date:    2018/4/19
 * Desc:
 */
@Slf4j
public class EqualsDemo {

    public static void main(String[] args) {
//        MyEqualsDemo demo_1 = new MyEqualsDemo("111", "111");
//        MyEqualsDemo demo_2 = new MyEqualsDemo("222", "222");
//        MyEqualsDemo demo_3 = new MyEqualsDemo("111", "111");
//
//        log.info("demo_1 hashcode is {}", demo_1.hashCode());
//        log.info("demo_2 hashcode is {}", demo_2.hashCode());
//        log.info("demo_3 hashcode is {}", demo_3.hashCode());
//
//        log.info("demo_1 toString is {}", demo_1.toString());
//        log.info("demo_2 toString is {}", demo_2.toString());
//        log.info("demo_3 toString is {}", demo_3.toString());
//
//        log.info("demo_1 == demo_3 result is {}", demo_1 == demo_3);    // False
//        log.info("demo_1.equals(demo_3) result is {}", demo_1.equals(demo_3));  // True

        log.info("-----------------------------------------------------");

        MyEqualsDemo demo_1 = new MyEqualsDemo("111", "111");
        log.info("demo_1 hashcode is {}", demo_1.hashCode());

        Map<MyEqualsDemo, String> map = new HashMap<>();
        map.put(demo_1, "demo_1");
        log.info("map.get(demo_1) is {}", map.get(demo_1));

        demo_1.setField_1("change field_1");
        log.info("now demo_1 hashcode is {}", demo_1.hashCode());
        log.info("map.get(demo_1) is {}", map.get(demo_1));

//        Map<int, String> map1 = new HashMap<>();
//        Map<String, int> map2 = new HashMap<>();
        Map<Object, Object> map1 = new HashMap<>();
        map1.put(null, "null_key");
        map1.put("null_value", null);
        log.info("map1 content is {}", map1.toString());
    }
}

class MyEqualsDemo {
    private String field_1;

    private String field_2;

    public MyEqualsDemo(String field_1, String field_2) {
        this.field_1 = field_1;
        this.field_2 = field_2;
    }

    public String getField_1() {
        return field_1;
    }

    public void setField_1(String field_1) {
        this.field_1 = field_1;
    }

    public String getField_2() {
        return field_2;
    }

    public void setField_2(String field_2) {
        this.field_2 = field_2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyEqualsDemo that = (MyEqualsDemo) o;

        return (field_1 != null ? field_1.equals(that.field_1) : that.field_1 == null) && (field_2 != null ? field_2.equals(that.field_2) : that.field_2 == null);
    }

    @Override
    public int hashCode() {
        int result = field_1 != null ? field_1.hashCode() : 0;
        result = 31 * result + (field_2 != null ? field_2.hashCode() : 0);
        return result;
    }
}
