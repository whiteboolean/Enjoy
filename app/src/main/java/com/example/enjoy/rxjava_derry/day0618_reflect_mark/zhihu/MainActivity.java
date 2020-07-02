package com.example.enjoy.rxjava_derry.day0618_reflect_mark.zhihu;

import android.util.Log;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainActivity {

    static Map<String, Button> map = new HashMap<>();

    @Test
    public void test() {
        Button button = new Button();
        button.setTag("button1");
        Button button1 = new Button();
        button1.setTag("button2");
        map.put("button1", button);
        map.put("button2", button1);

        ViewInject.injectEvent(this, map);
//        Button button = map.get("button1");
//        assert button != null;
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick() {
//                System.out.println("哈哈哈哈");
//            }
//        });

    }


//    @OnClick({"button1","button2"})
//    public void run(Button button) {
//        switch (button.getTag()) {
//            case "button1":
//                System.out.println("Button1执行了");
//                break;
//            case "button2":
//                System.out.println("Button2执行了");
//                break;
//        }
//    }

}
