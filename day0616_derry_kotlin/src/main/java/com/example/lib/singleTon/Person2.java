package com.example.lib.singleTon;

import java.io.IOException;
import java.io.InputStream;

//懒汉式
//1.构造函数私有化
//1.声明全局变量
public class Person2 {

    private static Person2 person2 = null;

    private Person2() {

    }


    public static Person2 getInstance() {
        if (person2 == null) {
            person2 = new Person2();
        }
        return person2;
    }

    public String inputStream2String(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

}
