package com.example.enjoy;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解： 注解上面的注解
 *
 * 1.@Target(ElementType.TYPE) 声明该注解的作用范围--- 用来修饰
 * 2.@Rentention(RetentionPolicy.Source) 保留到哪一个级别
 * 只有三个值  Retention.Source  Retention.Class Retention.RunTime
 */
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Ray {
    int value() ;
    int id();
}
