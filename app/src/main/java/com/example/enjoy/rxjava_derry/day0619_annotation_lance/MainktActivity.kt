package com.example.enjoy.rxjava_derry.day0619_annotation_lance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.enjoy.R
import kotlinx.android.synthetic.main.activity_main6.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainktActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)



        button8.setOnClickListener {
            Thread {
                println("current name1 ${Thread.currentThread().name}")
                runOnUiThread {
                    println("current name2 ${Thread.currentThread().name}")
                }
                println("current name3 ${Thread.currentThread().name}")
                runOnUiThread {
                    println("current name4 ${Thread.currentThread().name}")
                }
            }.start()
        }

        button9.setOnClickListener {
            GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    println("current name1 ${Thread.currentThread().name}")
                }
                println("current name2 ${Thread.currentThread().name}")
                withContext(Dispatchers.Default) {
                    println("current name3 ${Thread.currentThread().name}")
                }
                println("current name4 ${Thread.currentThread().name}")
                withContext(Dispatchers.Main) {
                    println("current name5 ${Thread.currentThread().name}")
                }
            }
        }

    }


    /**
     * lambda
     */
    private fun classicIoCode1() {
        thread {
            print("哈哈哈哈哈 ${Thread.currentThread().name}")
        }
    }
}