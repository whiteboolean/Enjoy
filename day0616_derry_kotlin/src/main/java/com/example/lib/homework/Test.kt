package com.example.lib.homework

import kotlin.concurrent.fixedRateTimer

const val a = 1


class Test {

    var a = 1
    val c = 2


    fun main() {
        //一.val和var
        //1.val 相当于final
        //2.var 相当于没有final
        //3.const var 相当于static final
        val a: Int = 1
        var aa = 234
        val fuc: (Int, Int) -> Int = { a, b -> (a + b) }
        val e1 = fuc(1, 2)
        var b = 2
        var c = "aaa"
        var d = true
        var e = a.plus(b)

        var f = "111"
        var g = "123"
//        var h = f + g
        var h = "${f}${g}"

        var i = test1(null)
        var i1 = test1("null")


        //判断一个数是否在某个区间
        println(a in 1..6)

        //2.比较和数组

        val ist = if (a > aa) {
            println("a大")
            "a大"
        } else {
            print("aa大")
            "aa大"
        }

        var j = listOf(1, 2, 3, 4)
        var k = Array(3) { value -> value + 20 }

        val l = 2
        val m = "你好"


        j.forEach {
            print(j)
        }

        j.forEachIndexed { index, i ->
            print(index + i)
        }


        for (lo in 1..10 step 2) {
            print(lo)
        }

        bb@ for (kim in 1 downTo 10) {
            aa@ for (paul in 1..10) {
                    break@bb
            }
        }

        //含前不含后
        for (kim in 1 until 10) {

        }


    }


    private fun test1(str: String?): Int {
        return str?.length ?: 12 //elvis
    }

    private fun whenfun(l: Any) {
        when (l) {
            1, 2, 3, 4 -> {
                println("在1234区间")
            }
            is Int -> {
                println("是int类型")
            }
        }
    }


}