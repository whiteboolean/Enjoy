package com.example.enjoy;


import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IntDef(value = {MainActivity.A, MainActivity.B})
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface LimitedAno {

}
