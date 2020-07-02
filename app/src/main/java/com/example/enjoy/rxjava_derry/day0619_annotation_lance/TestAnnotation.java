package com.example.enjoy.rxjava_derry.day0619_annotation_lance;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface TestAnnotation {

}
