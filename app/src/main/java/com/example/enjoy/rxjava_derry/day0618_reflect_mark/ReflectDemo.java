package com.example.enjoy.rxjava_derry.day0618_reflect_mark;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {


    @Test
    public void test() throws Exception {
        //实例化对象的标准用法
        Servant servant = new Servant();
//        servant.service("Hello" );

        //运行时
        Class<Servant> servantClass = Servant.class;
        Servant servant1 = servantClass.newInstance();


//        Class aClass = servant.getClass();
        Method service = servantClass.getDeclaredMethod("service", String.class);
        Method me = servantClass.getDeclaredMethod("me", int.class,String.class,String.class);
        service.setAccessible(true);
        service.invoke(servant,"hello");
        me.invoke(servant,12,"1","1");

//        Field i = servantClass.getDeclaredField("i");
//        i.setAccessible(true);
//        i.set(servant1,2);
//        System.out.println(i.get(servant1));


//        Constructor<?>[] constructors = servantClass.getConstructors();
        //获取本类以及父类中所有的方法(不包含私有)
//        Method[] methods = servantClass.getMethods();
//        for (Method m:methods){
////            System.out.println(" "+ m.getName()+ "()");
//        }


        //获取本类的所有方法(包含私有)
//        Method[] declaredMethods = servantClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println(" "+declaredMethod.getName()+"()");
//        }

    }


}
