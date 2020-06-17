package com.example.lib.kotlin_.day0616_kotlin1

class Test{



    val i  = "AAA"

    //不加inner不算内部类，属于嵌套类，嵌套类和内部类没有半毛钱关系，
    //嵌套类可以在类里面在写一个类，但是这个类和外部类不交互
    //
    inner class Sub{

        fun  show(){
            println("aaa：$")
        }

        inner class Sub{

        }

    }

    fun A(){

        fun B(){
             fun C(){

                 fun D(){

                 }
             }
        }
    }

}