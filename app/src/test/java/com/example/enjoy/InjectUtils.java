package com.example.enjoy;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InjectUtils {


    public static void injectView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();

        //获取所有全局变量
        Field[] declaredFields = aClass.getDeclaredFields();

        /**
         *
         * Field[] 获取自己和父类的成员但是不包括private，只能获取public //
         *
         * class.getSuperClass() 获取父类的class
         *
         * declaredFields; 获取自己的成员， 不包括父类
         *
         */

        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(InjectView.class)){
                InjectView annotation = declaredField.getAnnotation(InjectView.class);
                int value = annotation.value();
                try {
                    View v = activity.findViewById(value);
                    declaredField.setAccessible(true);
                    declaredField.set(activity, v);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
