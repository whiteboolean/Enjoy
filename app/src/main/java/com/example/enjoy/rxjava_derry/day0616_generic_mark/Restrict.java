package com.example.enjoy.rxjava_derry.day0616_generic_mark;

public class Restrict<T> {
    private T data;

    public Restrict() {
    }

    public Restrict(T data) {
//        data = new T;
        this.data = data;
    }


    //这里没办法使用实例化
    //因为泛型是我们实例化的时候才确定的类型
//    private static T instance ;

    //这样可以 静态方法本身是泛型方法就行
    private static <T> T getInstance(T a) {
        return a;
    }

    private static <T> Restrict<T> getInstance2(Restrict<T> t) {
        return t;
    }


    public static void main(String[] args) {
//        Restrict<Double>
//        Restrict<double> //基本类型不可以
//        if (Restrict<Doubl)

        Restrict<Double> a1 = new Restrict<>();
        Restrict<Integer> a2 = new Restrict<>();

        System.out.println(a1.getClass() == a2.getClass());
//        System.out.println(a);


    }


}
