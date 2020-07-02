package com.example.enjoy.rxjava_derry.day0618_reflect_mark;

import com.example.enjoy.rxjava_derry.day0618_reflect_mark.dynamic_delegate.RealSubjectA;
import com.example.enjoy.rxjava_derry.day0618_reflect_mark.dynamic_delegate.SubjectDynamic;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client   {



    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
//            TestDemo testDemo = new MyDemoClass();
//            setTestDemo(testDemo);
//
//            Method method1 = view.getClass().getMethod(s, aClass2); //View.setOnClickListener() //获得方法
//            method1.invoke(view, proxy);
//
//            Method setTestDemo = Client.class.getMethod("setTestDemo", TestDemo.class);
//            setTestDemo.invoke(Client.class.newInstance(),new MyDemoClass());
//
//
//            Class<Client> clientClass = Client.class;
//            Client client = clientClass.newInstance();
//
//            client.setTestDemo(new TestDemo() {
//                @Override
//                public void test(String name) {
//                    System.out.println("接口测试");
//                }
//            });


//            SubjectDynamic subjectDynamic = new RealSubjectA();
//        SubjectDynamic s = System.out::println;
//        SubjectDynamic a = new SubjectDynamic() {
//            @Override
//            public void sell(String name) {
//
//            }
//
//
//        };
//            Object dynamic = Proxy.newProxyInstance(subjectDynamic.getClass().getClassLoader(),
//                    new Class[]{SubjectDynamic.class}, new InvocationHandler() {
//                        @Override
//                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                            method.invoke(subjectDynamic, args);
//                            return null;
//                        }
//                    });
//
//
//            SubjectDynamic s1 = (SubjectDynamic) dynamic;
//            s1.sell("卖鱼");
//
//
//
//        Class<? extends SubjectDynamic> aClass = s.getClass();
//        Method sell = aClass.getMethod("sell", String.class);
//        sell.invoke(s,"你好");


            //这里用到了，里氏替换原则，参数为接口或者父类，然后传子类
            //多态
            //什么是多态？同一个事物的不同种形态
            //1.要有继承关系
            //2.子类要重写父类方法
            //3.父类引用要指向子类对象
//        Subject realSubject = new RealSubject();
//        ProxyDelegate proxyDelegate = new ProxyDelegate();
//        proxyDelegate.setRealSubject(realSubject);
//        proxyDelegate.sellThing("充气娃娃");
//
//        System.out.println("------------------");
//
//        SubjectB realSubjectB = new RealSubjectB();
//        ProxyDelegate proxyDelegate1 = new ProxyDelegate();
//        proxyDelegate1.setRealSubjectB(realSubjectB);
//        proxyDelegate1.sing("我爱你中国");
//
//        System.out.println("------------------");

        SubjectDynamic subjectDynamic = new RealSubjectA();
        SubjectDynamic subjectDynamic1  = (SubjectDynamic) Proxy.newProxyInstance(
                subjectDynamic.getClass().getClassLoader(),
                new Class[]{SubjectDynamic.class},
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("this是啥？："+this);
                return method.invoke(subjectDynamic,args);
            }
        });
        subjectDynamic1.sell("卖货");



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
