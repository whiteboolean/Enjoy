package com.example.lib.kotlin_.day0616_kotlin1

data class User(val id:Int,val sex:String)

fun main(){

    val user = User(1, "难")
    val (myId,myName)  = user.copy()
    val (_,myName1)  = user.copy()
    print("myName:$myName")

    }
