package com.heatdeath.string_learn;

/**
 * Author:  heatdeath
 * Date:    2018/4/22
 * Desc:
 */
public class StringDemo1 {

    public static void main(String[] args) {
//        String str1 = "aaa";
//        String str2 = "bbb";
//        String str3 = "aaabbb";
//        String str4 = str1 + str2;
//        String str5 = "aaa" + "bbb";
//        System.out.println(str3 == str4); // false
//        System.out.println(str3 == str4.intern()); // true
//        System.out.println(str3 == str5);// true

        String str2 = "SEUCalvin";//新加的一行代码，其余不变
        String str1 = new String("SEU")+ new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
    }
}
