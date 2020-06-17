package com.example.lib.singleTon;

//双重加锁式单例模式
//为了线程安全
public class Person3 {

    private static volatile Person3 person3;

    private Person3() { }

    public static Person3 getInstance() {
        if (person3 == null) {
            synchronized (Person3.class) {
                if (person3 == null) {
                    person3 = new Person3();
                }
            }
        }
        return person3;
    }
}
