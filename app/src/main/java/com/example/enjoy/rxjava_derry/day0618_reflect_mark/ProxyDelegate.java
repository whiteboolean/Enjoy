package com.example.enjoy.rxjava_derry.day0618_reflect_mark;

public class ProxyDelegate implements Subject  {

    private Subject realSubject;
    private SubjectB realSubjectB;

    public SubjectB getRealSubjectB() {
        return realSubjectB;
    }

    public void setRealSubjectB(SubjectB realSubjectB) {
        this.realSubjectB = realSubjectB;
    }

    public void setRealSubject(Subject realSubject) {
        this.realSubject = realSubject;
    }


    //前置处理器
    private void doSthBefore(){
        System.out.println("根据需求，进行市场调研和产品分析");
    }

    //后置处理器
    private void doSthAfter(){
        System.out.println("精美包装，一条龙服务");
    }

    @Override
    public void sellThing(String thing) {
        doSthBefore();
        realSubject.sellThing(thing);
        doSthAfter();
    }


    @Override
    public void sing(String name) {
        doSthBefore();
        realSubject.sing(name);
        doSthAfter();
    }
}
