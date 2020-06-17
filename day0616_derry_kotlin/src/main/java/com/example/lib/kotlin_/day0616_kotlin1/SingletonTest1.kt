package com.example.lib.kotlin_.day0616_kotlin1


//静态内部类式
class SingleTon1 {

    object Holder {
        var instance = SingleTon1()
    }
    companion object {
        var instance = Holder.instance
    }
}

//懒汉式
class SingletonLazy1 private constructor() {
    private var instance: SingletonLazy1? = null

    fun getInstance(): SingletonLazy1? {
        if (instance == null) {
            instance = SingletonLazy1()
        }
        return instance
    }

}

//饿汉式单例模式
class SingletonHungry private constructor() {
    private val instance = SingletonHungry()
    fun getInstance(): SingletonHungry {
        return instance
    }

}


//kotlin特有的单例模式
object SingleTonObject {

    fun test(){

    }
}



