package com.frame.july_myview.what_is_view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

class ConflictViewGroup(context: Context, attributeSet: AttributeSet? = null, styleDef: Int) : ViewGroup(context, attributeSet, styleDef) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        TODO("Not yet implemented")
    }


    var mLastXIntercept = 0f
    var mLastYIntercept = 0f

    //外部拦截办法
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {


        var intercepted = false

        var x = ev.x
        var y = ev.y

        when (ev.action) {


            MotionEvent.ACTION_DOWN -> {

                intercepted = false

            }

            MotionEvent.ACTION_MOVE -> {

                var deltX = x - mLastXIntercept


            }

            MotionEvent.ACTION_UP -> {
                intercepted = false


            }

        }



        mLastXIntercept = x
        mLastYIntercept = y



        return super.onInterceptTouchEvent(ev)


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val action  = event?.action
        return action != MotionEvent.ACTION_DOWN
    }

}