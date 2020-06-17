package com.example.lib.singleTon;

//静态内部类
public class Person4 {

    public static Person4 getInstance() {
        return Instance.person4;
    }

    public static class Instance {
        private static Person4 person4 = new Person4();
    }
}
