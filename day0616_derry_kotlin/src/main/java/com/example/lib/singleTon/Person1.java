package com.example.lib.singleTon;

//饿汉式
//类加载就生成
//三步走战略
public class Person1 {

    //1.构造函数私有化
    private Person1(){}

    //2.声明成员变量返回当前类的实例
    private static Person1 instance = new Person1();

    //3.提供一个公共的方法
    public static Person1 getInstance(){
        return instance;
    }
}
