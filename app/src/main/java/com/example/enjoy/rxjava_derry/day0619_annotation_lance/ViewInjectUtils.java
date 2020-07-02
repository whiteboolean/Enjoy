package com.example.enjoy.rxjava_derry.day0619_annotation_lance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.IntDef;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ViewInjectUtils {

    /**
     * 注入布局
     */
    public static void injectViewLayout(Activity context) {
        //获取字节码
        Class<? extends Activity> clazz = context.getClass();
        //判断当前注解是否作用在class上面
        //A.isAnnotationPresent(B.class) 判断B注解是否作用在A上面
        if (clazz.isAnnotationPresent(LayoutViewId.class)) {
            LayoutViewId annotation = clazz.getAnnotation(LayoutViewId.class);
            if (annotation != null) {
                try {
                    Method setContentView = clazz.getMethod("setContentView", int.class);
                    setContentView.invoke(context, annotation.value());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 注入控件
     */
    public static void injectFiledView(Activity context) {
        Class<? extends Activity> aClass = context.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean annotationPresent = declaredField.isAnnotationPresent(ViewInject.class);
            if (annotationPresent) {
                ViewInject annotation = declaredField.getAnnotation(ViewInject.class);
                if (annotation != null) {
                    int value = annotation.value();
                    declaredField.setAccessible(true);
                    try {
                        Method findViewById = aClass.getMethod("findViewById", int.class);
                        declaredField.set(context, findViewById.invoke(context, value));
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

    }


    /**
     * AutoWired
     * 注入数据
     */
    public static void injectAutoWired(Activity activity) {
        Class<? extends Activity> cls = activity.getClass();
        //获得数据
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        //获得此类所有的成员
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(AutoWired.class)) {
                AutoWired autowired = field.getAnnotation(AutoWired.class);
                //获得key
                String key = TextUtils.isEmpty(autowired.value()) ? field.getName() : autowired.value();

                if (extras.containsKey(key)) {
                    Object obj = extras.get(key);
                    // todo Parcelable数组类型不能直接设置，其他的都可以.
                    //获得数组单个元素类型
                    Class<?> componentType = field.getType().getComponentType();
                    //当前属性是数组并且是 Parcelable（子类）数组
                    if (field.getType().isArray() &&
                            Parcelable.class.isAssignableFrom(componentType)) {
                        Object[] objs = (Object[]) obj;
                        //创建对应类型的数组并由objs拷贝
                        if (objs != null) {
                            obj = Arrays.copyOf(objs, objs.length, (Class<? extends Object[]>) field.getType());
                        }
                    }
                    field.setAccessible(true);
                    try {
                        field.set(activity, obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * 注入各种事件
     */

    public static void injectEvents(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> aClass1 = annotation.annotationType();
                //获取元注解
                EventType annotation1 = aClass1.getAnnotation(EventType.class);
                if (annotation1 == null) {
                    continue;
                }
                String s = annotation1.listenerSetter();
                //View.OnClickListener 是一个接口
                Class<?> aClass2 = annotation1.listenerType();
                try {
                    Method value = aClass1.getDeclaredMethod("id");
                    int[] views = (int[]) value.invoke(annotation);
                    method.setAccessible(true);
                    Object proxy = Proxy.newProxyInstance(
                            aClass2.getClassLoader(), new Class[]{aClass2}, new InvocationHandler() {
                                @Override
                                public Object invoke(Object proxy, Method method1, Object[] args) throws Throwable {
                                    //method:我们自定义的方法
                                    //activity：在哪个类里面写的方法
                                    method.invoke(activity, args);
                                    return null;
                                }
                            }
                    );
                    if (views != null && views.length != 0) {
                        for (int v : views) {
                            View view = activity.findViewById(v);
                            //找到当前注解上面的方法，我们自己定义的onClick还是onLongClick
                            Method method1 = view.getClass().getMethod(s, aClass2); //View.setOnClickListener() //获得方法
                            method1.invoke(view, proxy);

//                            view.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                }
//                            });




                            //执行方法
                            // view.setOnClickListener(new View.OnClickListener(){
//                            @Override
//                            public void onClick(View v) {
//                            }// })
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
