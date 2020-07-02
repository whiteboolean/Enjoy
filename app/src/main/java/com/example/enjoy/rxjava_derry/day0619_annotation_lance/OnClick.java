package com.example.enjoy.rxjava_derry.day0619_annotation_lance;


import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EventType(listenerSetter = "setOnClickListener", listenerType = View.OnClickListener.class)
public @interface OnClick {
    @IdRes int[] id();
}
