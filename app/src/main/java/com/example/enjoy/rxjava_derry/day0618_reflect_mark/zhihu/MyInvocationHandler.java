package com.example.enjoy.rxjava_derry.day0618_reflect_mark.zhihu;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;
    private Method method;

    public MyInvocationHandler(Object target, Method method){
        this.target = target;
        this.method = method;
    }
    @Override
    public Object invoke(Object proxy, Method _method, Object[] args) throws Throwable {
        Log.e("test", "method=" + _method.getName());
        Log.e("test", "args=" + args[0]);
        ///< method是解析注解时getDeclaredMethods获得的方法
        return method.invoke(target, args);
    }
}
