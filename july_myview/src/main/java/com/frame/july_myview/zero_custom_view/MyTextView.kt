package com.frame.july_myview.zero_custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class MyTextView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, styleDef: Int = 0)
    : AppCompatTextView(context, attributeSet, styleDef) {

    private var paint: Paint = Paint()
    private lateinit var fontMetrics: Paint.FontMetrics
    var percent: Float = 0f

    fun setPercents(percent: Float) {
        this.percent = percent
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.apply {
            color = Color.GREEN
            isAntiAlias = true
            strokeWidth = 4f
        }
        //画横线
        canvas.drawLine(0f, height / 2.toFloat(), width.toFloat(), height / 2.toFloat(), paint)
        //画竖线
        canvas.drawLine(width / 2.toFloat(), 0.toFloat(), width / 2.toFloat(), height.toFloat(), paint)
        drawCenterText(canvas)
        drawCenterTextClip(canvas)


    }

    private fun drawCenterText(canvas: Canvas) {
        val text = "我喜欢学习!"
        canvas.save()
        paint.apply {
            color = Color.RED
            textSize = 130.toFloat()
            isAntiAlias = true
            strokeWidth = 4f
        }
        fontMetrics = paint.fontMetrics
        //文字的宽度
        val 文字横坐标 = width / 2
        val 文字纵坐标 = height / 2 + (fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent
        //绘画文字的横标从中间开始
        paint.textAlign = Paint.Align.CENTER
        val measureText = paint.measureText(text)
        val left = 文字横坐标 - measureText / 2
        val right = left + measureText * percent
        val rect = Rect(right.toInt(), 0, width, height)
        canvas.clipRect(rect)
        canvas.drawText(text, 文字横坐标.toFloat(), 文字纵坐标, paint)
        canvas.restore()
    }


    private fun drawCenterTextClip(canvas: Canvas) {
        val text = "我喜欢学习!"
        canvas.save()
        paint.apply {
            color = Color.BLACK
            textSize = 130.toFloat()
            isAntiAlias = true
            strokeWidth = 4f
        }
        fontMetrics = paint.fontMetrics
        //文字的宽度
        val measureText = paint.measureText(text)
        val 文字横坐标 = width / 2
        val 文字纵坐标 = height / 2 + (fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent
        //绘画文字的横标从中间开始
        paint.textAlign = Paint.Align.CENTER
        val left = 文字横坐标 - measureText / 2
        val right = left + measureText * percent
        val rect = Rect(left.toInt(), 0, right.toInt(), height)
        canvas.clipRect(rect)
        canvas.drawText(text, 文字横坐标.toFloat(), 文字纵坐标, paint)
        canvas.restore()
    }

}