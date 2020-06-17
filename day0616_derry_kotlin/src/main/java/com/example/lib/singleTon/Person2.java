package com.example.lib.singleTon;

//懒汉式
//1.构造函数私有化
//1.声明全局变量
public class Person2 {

    private static Person2 person2  = null;

    private Person2(){

    }


    public static Person2 getInstance(){
        if (person2==null){
            person2 = new Person2();
        }
        return  person2;
    }

}
