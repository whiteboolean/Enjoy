package com.example.lib.kotlin_.day0616_kotlin1

fun main() {

    val number1: Int = 999
    val number2: Int = 888

    val max = if (number1 > number1) number1 else number2

    println(max).also {
        println("你好").also {
            print("哈哈哈")
        }
    }


    val x = 99
    val y = 29

    if (x in 1..20 && y in 1..20) {
        print("符合")
    } else {
        print("不符合")
    }

//    switch

    val number = 5

    when (number) {
        1 -> print("1")
        2 -> print("2")
        3 -> print("3")
        4 -> print("4")
        5 -> print("5")
        else -> {
            print("haha")
        }
    }

    when (number) {
        1, 2, 3, 4, 5, 6 -> {

        }
        else -> {

        }
    }

}