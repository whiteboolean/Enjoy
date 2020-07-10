package com.example.lib.bilibili_kt


class A : AInterface {
    override fun pubNumber(number: Int) {
        println("int")
    }

    override fun putNumber(number: Int) {
        println("Integer")
    }


    companion object {
        val a = A()
    }
}