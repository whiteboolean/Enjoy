package com.example.lib.kotlin_.day0616_kotlin1

fun main() {

    //数组使用方式
    //函数
    val numbers = arrayOf<String>("你好", "哈哈")

    print(numbers[0])
    print(numbers[1])

    val numbersInt = arrayOf(1, 2, 3, 4, 5)
    for (i in numbersInt) {
        println(i)
    }

    val a = arrayOf("1", "2")

    //第二种方式 value 0+ = 20 //循环累加 打印20次
    val numbers2 = Array(20) { value: Int -> (value + 100) }
    val number1 = Array(20) { a1 -> a1 + 1 }

//    print("number1:$number1")
    number1.forEach {v1 ->
        println("number1的值:$v1")
    }

//    for (value in numbers2) {
//        println(value)
//    }



}