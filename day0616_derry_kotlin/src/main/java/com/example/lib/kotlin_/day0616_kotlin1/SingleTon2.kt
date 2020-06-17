package com.example.lib.kotlin_.day0616_kotlin1

class SingleTon2 {
    fun show() {
        println("你哈")
    }

    //里面都是静态
    companion object {
        private var instance: SingleTon2? = null

        fun getInstance(): SingleTon2? {
            if (instance == null) {
                instance = SingleTon2()
            }
//            return instance!!
            return instance

        }

    }
}

fun main(){
    val singleTon2 = SingleTon2.getInstance()
    singleTon2?.show()
}