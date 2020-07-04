package com.frame.july_myview.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import kotlin.math.max


class MyViewGroup @JvmOverloads
constructor(context: Context,
            attributeSet: AttributeSet? = null,
            defStyleAttr: Int = 0) : ViewGroup(context, attributeSet, defStyleAttr) {


    val OFFSET = 100

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //1.测量自身
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //2.拿到自身mode和size
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        //3.把上一步确定的限制信息传递给每一个子View，然后子View开始measure自己的尺寸
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val layoutParams = child.layoutParams
            //适配zi
            val childWidthSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, layoutParams.width)
            val childHeightSpec = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, layoutParams.height)
            child.measure(childWidthSpec, childHeightSpec)
        }

        //4.获取子View测量后完成的尺寸
        //5.ViewGroup根据自身的情况，计算自己的尺寸
        var width = 0
        var height = 0
        when (widthMode) {
            MeasureSpec.EXACTLY -> width = widthSize
            MeasureSpec.AT_MOST, MeasureSpec.UNSPECIFIED -> {
                for (i in 0 until childCount) {
                    val child = getChildAt(i)
                    val widthAddOffSet = i * OFFSET + child.measuredWidth
                    width = max(width, widthAddOffSet)//获取最大的宽度
                }
            }
        }

        when (heightMode) {
            MeasureSpec.EXACTLY -> height = heightSize
            MeasureSpec.AT_MOST, MeasureSpec.UNSPECIFIED -> {
                for (i in 0 until childCount) {
                    val child = getChildAt(i)
                    height += child.measuredHeight
                }
            }
        }
        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //1.遍历子View
        //2.确定自己的规则
        //3.子view的测量尺寸
        //4.left，top，right，bottom
        //5.child,layout
        var left: Int
        var top = 0
        var right: Int
        var bottom: Int
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            left = i * OFFSET
            right = left + child.measuredWidth
            bottom = top + child.measuredHeight
            //摆放第一个值
            child.layout(left, top, right, bottom)
            top += child.measuredHeight
        }


    }
}