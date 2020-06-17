package com.example.lib.kotlin_.day0616_kotlin1

//静态内部类式单例模式
class NetManager {

    object Holder {
        val instance = NetManager()
    }


    //看不到 static 可以用派生操作来代替 ，会随着NetManager出生而出生
    //派生类里面的东西都是静态的
    companion object{
        fun getInstance(): NetManager = Holder.instance
    }


    fun  show(name:String){
        print("show:$name")
    }


}



//
fun main(){
    val net = NetManager.getInstance()
    net.show("你好")
}