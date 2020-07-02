package com.example.enjoy.rxjava_derry.day0618_reflect_mark.dynamic_delegate;

public class RealSubjectA implements SubjectDynamic {
    @Override
    public void sell(String name) {
        System.out.println("出售: "+name);
    }
}
