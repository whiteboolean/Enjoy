package com.example.lib.kotlin_.day0616_kotlin_zero
//
//import kotlinx.coroutines.*
//import org.junit.Test
//import javax.xml.bind.JAXBElement
//
//class Coroutines {
//
//
//    @Test
//    fun main() {
//        JAXBElement.GlobalScope.launch {
//            print("哈哈")
//            ioCode1()
//            uiCode1()
//        }
//    }
//
//    private fun uiCode1() {
//        print("Coroutine camp ui1 ${Thread.currentThread().name}")
//    }
//
//    private suspend fun ioCode1() {
//        withContext(Dispatchers.IO) {
//            print("Coroutine camp io1 ${Thread.currentThread().name}")
//        }
//    }
//
//}
