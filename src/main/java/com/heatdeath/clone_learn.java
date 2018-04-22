package com.heatdeath;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Author:  heatdeath
 * Date:    2018/4/22
 * Desc:
 */
@Slf4j
public class clone_learn {
    public static void main(String[] args) throws Exception {
        ParentClass parentClass_1 = new ParentClass("parentClass_1", "parentClass_1");
        ParentClass parentClass_2 = (ParentClass) parentClass_1.clone();
        log.info("{}", parentClass_1);
        log.info("{}", parentClass_2);

        parentClass_2.setField_1("parentClass_2");
        log.info("{}", parentClass_1);
        log.info("{}", parentClass_2);
    }


}

class ParentClass implements Serializable {
    public String field_1;
    public String field_2;

    public ParentClass(String field_1, String field_2) {
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
    public String toString() {
        return "ParentClass{" +
                "field_1='" + field_1 + '\'' +
                ", field_2='" + field_2 + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
