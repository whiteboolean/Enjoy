package com.frame.july_myview;

import org.junit.Test;

public class a {

    @Test
    public void test() {

        //0x7fffffff
        //-2^31-1  ---  2^31 -1
        int max = Integer.MAX_VALUE;

        //移位运算符
        //对于该数值的2进制的移位
        System.out.println(1);
        // 1 --- >二进制 0001
        // 1 -->右移两位 0000  0
        System.out.print("1>>2的值是:");
        System.out.print(1 >> 2);

        //由此可以得出结论
        //向右移动N位相当于除以2的N次方
        System.out.println("");
        //例子
        System.out.print("4>>2的值是:");
        System.out.print(4 >> 2);
        System.out.println("");
        System.out.print("16>>2的值是:");
        System.out.print(16 >> 2);

        System.out.println("-------------");
        //左移
        System.out.print("1<<2的值是:");
        System.out.println(1 << 2);
        //向左移动N位相当于乘以2的N次方

    }

}
