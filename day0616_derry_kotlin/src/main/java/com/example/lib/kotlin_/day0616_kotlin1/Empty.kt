package com.example.lib.kotlin_.day0616_kotlin1

//默认public final类
//需要用open去拿掉final
//abstract相当于open
abstract class Empty(id:Int) : CallBackH {

    //Kotlin 主构造和次构造，次构造要调用主构造函数
    val cl = ClassAndObject()
    val cl2 = ClassAndObject(1)
    val cls2 = ClassAndObject(2, '男')

    //在kotlin中全部都是没有默认值的
    //Java中成员函数有默认值，局部变量没有默认值
    //lateinit 懒加载 默认值 但是只能用在八种基本类型上面 八种基本类型上面 八种基本类型都是什么呢？
    // INT CHAR DOUBLE BOOLEAN FLOAT
    var name:String? =null


    class Full(id:Int)  : Empty(id){
        override fun callBackMethod(): Boolean {
            return false
        }
    }



}

