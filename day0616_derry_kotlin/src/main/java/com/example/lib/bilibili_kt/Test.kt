package com.example.lib.bilibili_kt

import org.jetbrains.annotations.TestOnly
import kotlin.reflect.KClass

fun main() {

    //1.`in`
    Test1.`in` //in在kotlin中是一个关键字
    //2.kotlin产生的类默认为KClass
    val simpleName = Test1::class.java.simpleName
    testClass(KotlinMain::class)
    testClass(KotlinMain::class.java)
    //3.Kotlin没有封装类
    //4.接收java数据的时候，如果无法普安段这个数据是空或者非空，一定要用可空数据类型接收
    testFormat("")
    //5.Kotlin没有静态变量与静态方法，如果java类中调用Object声明的kotlin类，则需要声明@JVMSTATIC
    //Kotlin中则不需要声明
//    StaicClassTest.sayMessage()

    //6
//    var age = 18
//    var name = "zhang tao"
//    println("我叫%d,我今年%d岁",name,age)
    /**
     * 7.函数的特性语法
     * 8.嵌套函数
     * 9.扩展函数
     * 10.Lambda闭包语法
     * 11.高阶函数
     * 12.内联函数
     */

    print()
    //1.参数可以有默认值 ， 可以大大减少构造方法的数量
    //2.函数嵌套 ;
    // 1)用途： 在某些条件下触发递归的函数 2).不希望被外部函数访问到的函数

    //3.扩展函数的静态解析
    //扩展函数通常应用于第三方库或者是一些没有办法控制的kotlin的类或者是java的类 ，如果想对这个类增加成员变量或者成员方法的时候
    //扩展属性

    //4.Lambda表达式
    Thread { ->
        {

        }
    }
    //如果lambda没有参数，可以省略箭头符号 ->
    //如果lambda是函数的最后一个参数，可以将大括号放在小括号的外面
    //如果函数只有一个参数且这个参数是lambda，则可以省略小括号
    Thread() {

    }

    //Lambda表达式参数是有上限的，有22个

    //5.函数是一等公民


    val echo = { name: String ->
        {
            println(name)
        }
    }


    onlyIf {
        print("你好")
    }

    val runnable = Runnable {
        println("Runnable::run")
    }
    val function:() -> Unit
    function = runnable::run
    onlyIf(true,function)

    //在kotlin中lambda表达式会被编译成匿名内部类的形式
    //如果在代码中有大量重复的lambda表达式，你的代码会生成很多临时的无用的对象
    //可以使用inline关键字优化代码
    //使函数的调用简化为语句的调用，减少临时变量的生成
    //inline大部分只会用来修饰高阶函数


    //类与对象
    //1.构造方法
    //2.访问修饰符
    //3.

}

inline fun onlyIf(isDebug: Boolean = false, block: () -> Unit) {
    if (isDebug) block.invoke()
}

fun function() {
    val str = "Hello World"
    fun say(count: Int = 10) {
        println(str)
        if (count > 0) {

            say(count - 1)
        }
    }
    say()
}


fun String.ktx(hha: String): String? {
    return hha
}

var String.guan: String
    get() = this.toString()
    set(value) {
        println("fas")
    }


fun print(name: String = "张涛"): String? {
    println("$name")
    return name
}

fun testClass(clazz: KClass<KotlinMain>) {
    println(clazz.simpleName)
}

fun testClass(clazz: Class<KotlinMain>) {
    print(clazz.simpleName)
}

fun testFormat(str: String) {
    var a = Test1.format(str)
//    var c:String = Test1.format(str)
    var b: String? = Test1.format(str)
}