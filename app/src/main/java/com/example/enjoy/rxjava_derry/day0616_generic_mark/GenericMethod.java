package com.example.enjoy.rxjava_derry.day0616_generic_mark;

public class GenericMethod {

    public <T> T genericMethod(T...a){
        return a[a.length/2] ;
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();

        genericMethod.genericMethod(1,2,3);
        genericMethod.genericMethod("1","2","2");
    }
}
