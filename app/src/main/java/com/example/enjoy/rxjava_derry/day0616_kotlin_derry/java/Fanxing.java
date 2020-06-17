package com.example.enjoy.rxjava_derry.day0616_kotlin_derry.java;

public class Fanxing {
    static class Fruit {//水果类

    }

    static class Apple extends Fruit { }

    static class Plate<T> {
        private T item;

        public Plate(T t) {
            item = t;
        }

        public void set(T t) {
            item = t;
        }

        public T get() {
            return item;
        }
    }

    static class Banana extends Fruit {
    }

    public static void main(String... args) {

        //装苹果的盘子，是一个装水果的盘子吗？ 不是
        // ? extends 上界通配符  只能 get 是 生产
        // ?是继承fruit的，只要是Fruit的子类都可以用
        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
        Plate<? extends Fruit> plate1 = new Plate<>(new Banana());

        plate.get();
        //plate.set(new Apple());

        //？ extends super 下界通配符 ，可以存东西
        Plate<? extends Fruit> plate2 = new Plate<>(new Apple());
        Plate<? super Fruit> plate3 = new Plate<>(new Apple());
//        Apple apple = plate3.get();
        plate3.set(new Apple());


        //PECS 原则
        //Producer extends Consumer super
        //


    }
}
