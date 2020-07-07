package com.frame.july_myview.what_is_view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class ConflictView  @JvmOverloads constructor(context: Context,attributeSet: AttributeSet? = null,styleDef :Int) : View (context,attributeSet,styleDef){


    var mLastX = 0f
    var mLastY = 0f

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        var x= event.x
        var y = event.y
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                var deltaX=  x - mLastX
                var deltaY = y - mLastY
                if (deltaX>deltaY){
                    parent.requestDisallowInterceptTouchEvent(false)
                }

            }
        }
        mLastY = x
        mLastY = y

        return super.dispatchTouchEvent(event)
    }



}