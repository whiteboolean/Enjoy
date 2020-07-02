package com.example.enjoy.rxjava_derry.day0616_generic_mark;

import org.junit.Test;

public class GenericClass<T> {

//    private static T instance;


    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Test
    void test(){
        G<String,String> g = new G();
        G<Double,Double> g1 = new G<>();


    }


}

class G<T, R> {

    T t;
    R r;

    public G() {
    }

    public G(T t, R r) {
        this.t = t;
        this.r = r;
    }

    public G(R r) {
        this.r = r;
    }
}
