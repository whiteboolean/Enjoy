package com.example.lib.singleTon;

public class Test {

    public static void main(String[] args) {
        //饿汉式
        Person1 person1 = Person1.getInstance();
        Person2 person2 = Person2.getInstance();
        Person3 person3 = Person3.getInstance();
        Person4 person4 = Person4.getInstance();
    }


}
