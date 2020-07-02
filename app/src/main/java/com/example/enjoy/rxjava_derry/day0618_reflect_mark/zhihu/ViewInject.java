package com.example.enjoy.rxjava_derry.day0618_reflect_mark.zhihu;

import java.lang.reflect.Method;
import java.util.Map;

public class ViewInject {


    public static void injectEvent(MainActivity act, Map<String, Button> map) {
        Class<? extends MainActivity> aClass = act.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(OnClick.class)) {
                try {
                    OnClick onClick = method.getAnnotation(OnClick.class);
                    String[] value = onClick.value();
                    for (String s : value) {
                        method.invoke(act, map.get(s));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
