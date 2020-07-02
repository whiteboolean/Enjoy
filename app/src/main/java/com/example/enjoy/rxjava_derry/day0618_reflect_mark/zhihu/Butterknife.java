package com.example.enjoy.rxjava_derry.day0618_reflect_mark.zhihu;

import android.content.Context;
import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Butterknife {


    public static void inject(Context context){
        Class<? extends Context> classObj = context.getClass();
        Method[] methods = classObj.getDeclaredMethods();
        ///< 1.动态代理方式
        for (Method method : methods) {
            if (method.isAnnotationPresent(OnClicks.class)) {
                OnClicks onClicks = method.getAnnotation(OnClicks.class);
                ///< 2.控件ID
                int[] viewId = onClicks.value();

                ///< 3 .创建一个点击事件代理对象【点击跳转过去可以发现接口里面有onClick方法】
                View.OnClickListener listenner = (View.OnClickListener) Proxy.newProxyInstance(View.OnClickListener.class.getClassLoader(),
                        new Class[]{View.OnClickListener.class}, new MyInvocationHandler(context, method));
                for (int id : viewId) {
                    ///< 4. 获取控件
                    Method methodFd = null;
                    try {
                        methodFd = classObj.getMethod("findViewById", int.class);
                        View viewObj = (View) methodFd.invoke(context, id);
                        ///< 设置View的setOnClickListener点击事件
                        Method targetMethod = viewObj.getClass().getMethod("setOnClickListener", View.OnClickListener.class);
                        ///< 会触发MyInvocationHandler的invoke方法
                        targetMethod.invoke(viewObj, listenner);
//                        viewObj.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                listenner.onClick(viewObj);
//                            }
//                        });

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
