package com.example.enjoy.rxjava_derry.day0619_annotation_lance;


import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import butterknife.OnClick;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EventType(listenerSetter = "setOnLongClickListener", listenerType = View.OnLongClickListener.class)
public @interface OnLongClick {
    @IdRes int[] id();
}
