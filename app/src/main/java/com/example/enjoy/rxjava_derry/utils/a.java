package com.example.enjoy.rxjava_derry.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class a {


    @Test
    public void test1(){
        Map<String,String> map = new HashMap<>();
        map.put("1","haha");
        map.put("1","fdafa");
        map.put("2","fdsafa");

        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
    }
}
