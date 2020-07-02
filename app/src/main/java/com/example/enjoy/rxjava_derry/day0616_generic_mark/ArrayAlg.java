package com.example.enjoy.rxjava_derry.day0616_generic_mark;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrayAlg {


    //这里怎么保证他有compare方法呢
//    public static <T> T min(T a, T b) {
//        if (a.compareTo(b) > 0) return a;
//        else return b;
//    }

    public <T> void copy(T a,T b){

    }

    //用限定性修饰符
    public static <T extends Comparable> T min(T a, T b) {
        if (a.compareTo(b) > 0) return a;
        else return b;
    }

    class Test implements Comparable<String> {
        @Override
        public int compareTo(String o) {
            return 1;
        }
    }

//可以使用多个接口，但是只能有一个类，类只能写到第一个位置
    public static <T extends ArrayList & Comparable & Serializable> T min(T a, T b) {
        if (a.compareTo(b) > 0) return a;
        else return b;
    }


    public Boolean test() {
//        if (1 > 2) return true;
//        else return false;

        ArrayAlg.min(new Test(), new Test());
        return false;
    }
}
