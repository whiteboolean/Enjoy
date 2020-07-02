package com.example.enjoy.rxjava_derry.day0619_annotation_lance;

import androidx.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //只能用在类,接口上
@Retention(RetentionPolicy.RUNTIME) //保留到运行时
@Inherited
public @interface LayoutViewId {
    @LayoutRes int value();
}
