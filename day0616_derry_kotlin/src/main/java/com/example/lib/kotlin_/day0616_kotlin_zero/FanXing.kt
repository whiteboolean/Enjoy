package com.example.lib.kotlin_.day0616_kotlin_zero


typealias funtypes = ()->Unit

class FanXing{


    fun copy1(dest:Array<Double>,src:Array<Double>){

    }

    fun<T,R> copy2(dest:Array<T>,src:Array<R>) {

    }

    fun<T> copy(dest:Array< T>,src:Array<T>){

    }

    fun main(){


        val a = listOf<Int>()

        val b = arrayOf(1,2,3)

        var list = listOf<String>()
        var array = arrayOf(1,2,3)

        var destDouble = arrayOfNulls<Int>(1)

        var srcDouble = arrayOf(1,2,3,4,4)
//        copy(destDouble,srcDouble)

//        kotlin可以定义声明处形变

        //lambda表达式
        var temp:(Int,Int) ->Int
        var sum  = {x:Int,y:Int ->x+y}

        var temp1:(Int) ->Unit

        temp1 = {
            println("${it}")
            it+2
        }




        fun test(s:String,display:(String)->Unit){
            print(s)
        }

        fun printS(s:String){
            print(s)
        }

        fun test1(func:()->Unit):Unit{
            fun test2(){
                func()
            }
            return test2()
        }

        fun test2(func:funtypes):Unit{
            fun test2(){
                func()
            }
            return test2()
        }



        //内置高阶函数

        kotlin.run {

        }

        var str = "1"
        str.run {

        }

        str.apply {

        }.apply {

        }

        str.map {

        }


        str.also {
            it.length
        }

        str.run {
            this.length
        }




    }





    interface Source<out T>{
        fun getT():T
    }

    fun test1(src:Source<String>){
        val dest:Source<Any>  =src
    }
}