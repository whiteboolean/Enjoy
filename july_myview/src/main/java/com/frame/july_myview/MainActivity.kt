package com.frame.july_myview

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), Handler.Callback {
    lateinit var handler: Handler
    var mCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //弹性滑动实现方式 1：Scroller
//        tv.setOnClickListener {
//            tv.smoothScrollTo((-100).plus(Random.nextInt(100)), (-100).plus(Random.nextInt(100)))
//        }

        //弹性滑动实现方式 2:view动画
//        ObjectAnimator.ofFloat(tv, "translationX", 0f, 100f).setDuration(100).start()

//
//        val startX = 0
//        val deltaX = 0
//        val animator = ValueAnimator.ofInt(0,1).setDuration(1000);
//        animator.addUpdateListener {
//            val fraction = it.animatedFraction
//            tv.scrollTo(startX .plus((deltaX*fraction).toInt()),0)
//        }
//        animator.start()


        Int.MAX_VALUE

        handler = Handler(this)
        tv.setOnClickListener {
            handler.sendEmptyMessage(0)
        }

    }

    override fun handleMessage(msg: Message): Boolean {
        mCount++
        if (mCount <= 30) {
            val fraction = mCount / 30.0f
            val scrollX = -fraction * 100
            tv.scrollTo(scrollX.toInt(), 0)
            handler.sendEmptyMessageDelayed(0, 33)
        }
        return true
    }


}