package com.example.lib.kotlin_.day0616_kotlin_zero


val nullStr:String? = null
var nulllStr:String? = null
fun main(){

    //非空校验
    var a :String? = null
    print(a!!.length)
    //非空断言只限于局部变量
    if (a!=null){
        print(a.length)
    }

    val user2 =User2()
    if (user2.isNameInit()){
        println(user2.name)
    }
//    if (user2::name.isInitialized){
//
//    }

    if (nulllStr!=null){
        print(nullStr?.length)
    }



}

class User2{

    lateinit var name:String // name交给我自己管理，jvm
    var age:Int = 0
    fun isNameInit():Boolean{
        return ::name.isInitialized
    }
}