package com.example.enjoy.rxjava_derry.day0618_reflect_mark;

import android.nfc.tech.NfcA;

//真实对象
public class RealSubject implements Subject{
    @Override
    public void sellThing(String thing) {
        System.out.println("出售物品:"+thing);
    }

    @Override
    public void sing(String name) {
        System.out.println("唱歌:"+ name);
    }
}
