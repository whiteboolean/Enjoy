package com.example.enjoy.rxjava_derry.day0616_generic_mark;

public interface GenericInterface<T> {
    T getData();
}

interface GenericInterface2 extends GenericInterface{


}

class GenericInterface3<String> implements GenericInterface<String>{

    @Override
    public String getData() {
        return null;
    }
}