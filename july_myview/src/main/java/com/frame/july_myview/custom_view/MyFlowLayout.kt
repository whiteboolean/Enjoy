package com.frame.july_myview.custom_view

import android.content.Context
import android.text.Layout
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.frame.july_myview.R
import com.frame.july_myview.a
import kotlin.math.max

class MyFlowLayout(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int)
    : ViewGroup(context, attributeSet, defStyleAttr) {

    var lineWidth = 0
    var maxLineHeight = 0

    var finalWidth = 0
    var finalHeight = 0

    var lineChildHeight = mutableListOf<Int>()
    var lineChild = mutableListOf<View>() //每一行的子view
    var allLinesChild = mutableListOf<MutableList<View>>() //所有行的view

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //测量自己
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //拿到测量模式
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        init()

        var allLineHeight = 0
        var maxLineWidth = 0

        for (i in 0 until childCount) {
            val child = getChildAt(i)
            //测量子view
            measureChild(child, measuredWidth, measuredHeight)
            //拿到子控件的宽高，然后去测量父控件的宽和高
            val childWith = child.measuredWidth
            val childHeight = child.measuredHeight

            //换行
            if (childWith + lineWidth > widthSize) {
                allLinesChild.add(lineChild)
                lineChild = mutableListOf() //创建新的一行
                maxLineWidth = max(maxLineWidth, lineWidth)
                allLineHeight += maxLineHeight
                lineChildHeight.add(maxLineHeight)
                lineWidth = 0
                maxLineHeight = 0
            }

            lineChild.add(child)
            lineWidth += childWith
            maxLineHeight = max(childHeight, maxLineHeight)

            if (i == childCount - 1) {
                allLineHeight += maxLineHeight
                maxLineWidth = max(maxLineWidth,lineWidth)
                allLinesChild.add(lineChild)
                lineChildHeight.add(maxLineHeight)

            }


        }

        when (widthMode) {
            MeasureSpec.EXACTLY -> finalWidth = heightSize
            MeasureSpec.UNSPECIFIED, MeasureSpec.AT_MOST -> finalWidth = maxLineWidth
        }
        when (heightMode) {
            MeasureSpec.EXACTLY -> finalHeight = height
            MeasureSpec.UNSPECIFIED, MeasureSpec.AT_MOST -> finalHeight = maxLineHeight
        }


        setMeasuredDimension(finalWidth, finalHeight)

        reMeasureChild()

    }

    private fun reMeasureChild() {

        val lineSize =  allLinesChild.size
        for (i in 0 until lineSize){


        }
    }

    private fun init() {
        lineChildHeight = mutableListOf()
        lineChild = mutableListOf()
        allLinesChild = mutableListOf()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var currX = 0
        var currY = 0

        for (i in 0 until allLinesChild.size) {
            var mutableList = allLinesChild[i]
            val lineChildHeight = lineChildHeight[i]
            for (view in mutableList) {
                val left = currX
                val top = currY
                val right = left + view.measuredWidth
                val bottom = top + view.measuredHeight
                view.layout(left, top, right, bottom)
                currX += view.measuredWidth
            }
            currY += lineChildHeight
            currX = 0
        }


    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return LayoutParams(context, attrs)
    }

    override fun generateLayoutParams(p: ViewGroup.LayoutParams): ViewGroup.LayoutParams {
        return LayoutParams(p)
    }


    override fun generateDefaultLayoutParams(): ViewGroup.LayoutParams {
        return LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun checkLayoutParams(p: ViewGroup.LayoutParams?): Boolean {
        return super.checkLayoutParams(p) && p is LayoutParams
    }


    companion object {
        class LayoutParams : MarginLayoutParams {
            var gravity = -1

            constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
                val a = context.obtainStyledAttributes(attrs, R.styleable.MyViewGroup)

                gravity = a.getInt(R.styleable.MyViewGroup_android_gravity, -1)
                a.recycle()
            }

            constructor(width: Int, height: Int) : super(width, height)

            constructor(source: ViewGroup.LayoutParams) : super(source)

        }


    }


}