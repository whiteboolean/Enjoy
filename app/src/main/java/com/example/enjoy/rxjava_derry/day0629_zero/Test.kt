package com.example.enjoy.rxjava_derry.day0629_zero

import com.example.enjoy.rxjava_derry.utils.a
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Test
import kotlin.concurrent.thread

suspend fun main() {
    print("fdsa")
    delay(2000)

    print("21321")
}

class Test {


    suspend fun main() {
        val a = """
            ?fdsa
            ?fa
            ?fads
            ?fdsa
            ?fdsa
            ?fdas
        """.trimMargin("?")
        print(a)
    }

    @Test
    fun test1(): Unit {

        var info: String? = null

        val s = info?.length ?: "你很牛逼"

        for (i in 1..10) {
//            print(i)
        }


        for (i in 1 until 10) {
//            print(i)
        }

        val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        list.forEachIndexed { index, i ->
//            println("index:${index},i:${i}")
        }

        val number2 = Array(20) { value: Int ->
            (value + 200)
        }

        for (i in number2) {
//            println(i)
        }


        sun1 {

        }


        //非阻塞，类似守护线程， 主线程没有就不执行了
        GlobalScope.launch {
            delay(2000)
            println(Thread.currentThread().name + "fdasfds")
        }

        println("fdsafdsafsda")

        println("bbbbbb")

        sun2({ a, b, c ->

//            print(a.plus(b))
        }, "2")


        val job = GlobalScope.launch {

            repeat(1000) {
                delay(1000)
                println("3432432333333")
            }
        }

        println("kaishi")
        Thread.sleep(2000)
        job.cancel()

        t01(::run01)



        3.myLet2 {
            +3
        }

        ktrun(true, "你好") {
            print(Thread.currentThread().name)
        }


    }

    fun ktrun(
            start: Boolean = true,
            name: String?,
            myRunAction: () -> Unit): Thread {
        val hread = object : Thread() {
            override fun run() {
                myRunAction()
            }
        }
        if (start) {
            hread.start()
        }
        return hread

    }


    fun <T, R> T.myLet2(mm: T.() -> R): R {
        return mm()
    }

    fun sun1(mm: () -> Unit) {
        mm.invoke()
    }

    fun sun2(mm: (Int, Boolean, String) -> Unit, a: String) {
        mm(9, true, "1")
    }


    /**
     * 高阶函数
     */
    inline fun t01(mm: (Int) -> String) {
        mm(88)
    }


    fun run01(number: Int): String = "OK${number}"


    fun <T> T.run() {
        println("哈哈")
    }
}