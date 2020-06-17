package com.example.lib.kotlin_.day0616_kotlin1

//变量默认public
//类默认public final
//接口和抽象类默认public open
class SingleTonTest {

     val instance: SingleTonTest? = null

    companion object {
        fun getInstance(): SingleTonTest {
            return SingleTonTest()
        }
    }

}

