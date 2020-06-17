package com.example.lib.kotlin_.day0616_kotlin1

fun main(){

    //自定义标签
    aa@for (i in 1..10){
       bb@ for (j in 1..10){
            println("i:$i,j$j")
            if (j == 2){
                break@aa
            }
        }
    }

    var items = listOf("li","ll","fds")
//    for (item in items){
//        print(items)
//    }
//    items.forEach {
//        println("你好:$it")
//    }
//
//    for (item in items.indices) {
//        print("下标:$item,对应的值${items[item]}")
//    }

    items.forEachIndexed { index, s ->
        println("index:$index , s:$s")
    }

}

class Derry{

    val i =  "AAA"
    fun show(){
        print(i)
        print(this.i)
        print(this@Derry.i)
    }
}