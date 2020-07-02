package com.example.enjoy.rxjava_derry.day0619_annotation_lance;


@TestAnnotation
public class AnnotationDemo {

    @TestAnnotation

    public int params = 2;


    public static void main(String[] args) {
        test(2);
    }


    public static void test(@Ray(value = 2) int i) {


    }

}
