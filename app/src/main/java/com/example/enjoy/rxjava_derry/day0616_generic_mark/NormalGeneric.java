package com.example.enjoy.rxjava_derry.day0616_generic_mark;

public class NormalGeneric<T> {

    public T data;

    public NormalGeneric() {
    }

    public NormalGeneric(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static void main(String[] args) {
        NormalGeneric<String> normalGeneric = new NormalGeneric<>();
    }


}

