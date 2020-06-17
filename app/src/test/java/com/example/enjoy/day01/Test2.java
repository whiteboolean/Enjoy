package com.example.enjoy.day01;

import org.junit.Test;

public class Test2 {



    public Test2(){
        System.out.println("aaa");
    }

    B b = new B();


//    static {
//        System.out.println("bbb");
//    }
//    static B b1 = new B();

    @Test
    public void main() {
//        Test2 t = new Test2();
//        t.test2();
    }
}



class A {
    A(){
        System.out.println("AAAAA");
    }

    protected void test2(){

        System.out.println("父类测试方法test2");
    }
}

class B{
    B(){
        System.out.println("BBBB");
    }
}



