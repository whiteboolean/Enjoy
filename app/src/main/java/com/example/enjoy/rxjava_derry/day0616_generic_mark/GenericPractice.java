package com.example.enjoy.rxjava_derry.day0616_generic_mark;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericPractice<T> {

    public static void main(String[] args) {
        System.out.println("aa");
    }

    private static int add(int x, int y) {
        return x + y;
    }

    private static Double add(Double a, Double b) {
        return a + b;
    }

    private static String add(String a, String b) {
        return a + b;
    }

//    private static <T extends Integer> T add(T a,T b){
//        return t;
//    }



    @Test
    public void test1() {

//        List list = new ArrayList();
//        list.add("123");
//        list.add("123");
//        list.add(123) ;
//
//        for (int i = 0; i < list.size(); i++) {
//            String number = (String) list.get(i);
//            System.out.println(number);//会报类型转化错误
//        }
//        List<String> list1 = new ArrayList<>();
//        list1.add(123);
//        list.add("123");
//        GenericPractice<String> genericPractice = new GenericPractice();
//        genericPractice.get(1123);

    }

    private <T> void get1(T t){

    }

    private static <T> void get1(){

    }

    private static<T> T get2(T t){
        return t ;
    }

    private static<T ,R extends ArrayList<R> & Comparable> T get3(T r){
        return r;
    }


    private void get(T e){
        System.out.println("adf ");
    }



}
