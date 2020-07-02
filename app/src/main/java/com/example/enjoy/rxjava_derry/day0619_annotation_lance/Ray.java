package com.example.enjoy.rxjava_derry.day0619_annotation_lance;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@IntDef({1, 2})
@Target({ElementType.PARAMETER,ElementType.FIELD})
public @interface Ray {
    int value();
}
