package com.example.lib.bilibili_kt;

import java.io.File;

import kotlin.io.FilesKt;
import kotlin.text.Charsets;

public class Test1 {
    public static final String in = "in" ;


    public static String format(String format){
        return format.isEmpty()?null:format;
    }


    public static void main(String[] args) {
        StaicClassTest.sayMessage("build.gradle");

        File file = new File("build.gradle") ;
        String content = FilesKt.readText(file, Charsets.UTF_8);
        System.out.println(content);
    }
}



