package com.frame.july_myview

import android.content.Context
import android.content.res.Resources
import android.icu.util.Measure
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewStructure
import kotlin.math.max


// @JvmOverloads 如果你没有加上这个注解，它只能重载相匹配的的构造函数，而不是全部
class MyFlowLayout @JvmOverloads
constructor(context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0) : ViewGroup(context, attrs, defStyleAttr) {

    private val TAG = "MyFlowLayout"
    private val mHorizontalSpacing = dp2px(16)
    private val mVerticalSpacing = dp2px(8)
    private lateinit var allLines: MutableList<MutableList<View>>
    private lateinit var lineHeights: MutableList<Int>

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        initView()
        var lineViews = mutableListOf<View>()
        var lineWidthUsed = 0
        var lineHeight = 0

        val selfWidth = MeasureSpec.getSize(widthMeasureSpec)
        val selfHeight = MeasureSpec.getSize(heightMeasureSpec)

        var parentNeededWidth = 0
        var parentNeededHeight = 0


        for (i in 0 until childCount) {

            val childView = getChildAt(i)

            val childLayoutParams = childView.layoutParams

            val childWithMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childLayoutParams.width)

            val childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childLayoutParams.height)

            childView.measure(childWithMeasureSpec, childHeightMeasureSpec)


            val childMeasureWidth = childView.measuredWidth

            val childMeasureHeight = childView.measuredHeight

            if (childMeasureWidth.plus(lineWidthUsed).plus(mHorizontalSpacing) > selfWidth) {
                allLines.add(lineViews)
                lineHeights.add(lineHeight)

                parentNeededHeight += lineHeight.plus(mVerticalSpacing)
                parentNeededWidth = max(parentNeededWidth, lineWidthUsed.plus(mHorizontalSpacing))

                lineViews = mutableListOf()
                lineWidthUsed = 0
                lineHeight = 0
            }

            lineViews.add(childView)
            lineWidthUsed += childMeasureWidth.plus(mHorizontalSpacing)
            lineHeight = max(lineHeight, childMeasureHeight)

            if (i == childCount - 1) {
                parentNeededWidth = max(parentNeededWidth, lineWidthUsed)
                parentNeededHeight += lineHeight
                lineHeights.add(lineHeight)
                allLines.add(lineViews)
            }
        }


        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        val realWidth = if (widthMode == MeasureSpec.EXACTLY) selfWidth else parentNeededWidth
        val realHeight = if (heightMode == MeasureSpec.EXACTLY) selfHeight else parentNeededHeight


        setMeasuredDimension(realWidth, realHeight)
    }

    private fun initView() {
        allLines = mutableListOf()
        lineHeights = mutableListOf()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        val lineCount = allLines.size

        //1.拿到当前viewGroup的paddingTop和paddingLeft
        var curL = paddingLeft
        var curT = paddingTop

        for (i in 0 until lineCount) {
            val mutableList = allLines[i]
            val lineHeight = lineHeights[i]
            for (view in mutableList) {
                val left = curL
                val top = curT
                val right = left + view.measuredWidth
                val bottom = top + view.measuredHeight
                view.layout(left, top, right, bottom)
                curL = right + mHorizontalSpacing
            }

            curL = paddingLeft
            curT += lineHeight.plus(mVerticalSpacing)
        }

    }

    private fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), Resources.getSystem().displayMetrics).toInt()
    }

}
