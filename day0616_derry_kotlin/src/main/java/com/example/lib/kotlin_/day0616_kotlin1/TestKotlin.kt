package com.example.lib.kotlin_.day0616_kotlin1

//String
//String?
//Int
//Int?类型
fun main() {
    val info: String? = null
//    println(info!!.length) //会引发空指针异常
    println(info?.length) //不会引发空指针异常
    val count: (Int, Int) -> Int = { umb1, numb2 -> umb1 + numb2 }
//    print(count(1,2))
//
//
//    for (i in 1..9){
//        println(i)
//    }

    print(info?.length?:"你很牛逼") //猫王表达式 很重要**


//    for (i in 9 downTo 1){
//        println(i)
//    }

//    for (i in 9..10) {
//        println(i)
//    }
//
//    val value = 99
//    if (value in 1..100){
//        println("包含1到100")
//    }
//
//    if (value in 1..8){
//        print("bub")
//    }else{
//        print("不包含")
//    }
//
//    //指定步长
//    for (i in 1..10 step 2){
//        print(i)
//    }
//
//    //排除最后一个元素
//    for (i in 1 until 10){
//        print(i)
//    }

    val name1 = "111"
    val name2 = "111"
    print(name1.equals(name2))
    //比较值本身
    println(name1 == name2) //Kotlin里面 == 等于比较值 等价于java中的 equals
    println(name1 === name2)

    //比较对象地址
    val test1:Int  = 10000
    val test2 :Int =  20000
    print(test1 === test2)
}


fun testMethod(): Int? {
    return null
}