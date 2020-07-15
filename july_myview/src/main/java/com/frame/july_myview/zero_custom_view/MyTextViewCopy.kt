package com.frame.july_myview.zero_custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.annotation.IntDef
import androidx.appcompat.widget.AppCompatTextView

class MyTextViewCopy @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, styleDef: Int = 0)
    : AppCompatTextView(context, attributeSet, styleDef) {

    private var paint: Paint = Paint()
    private lateinit var fontMetrics: Paint.FontMetrics
    var percent: Float = 0f
    var textContent: String? = null
    private var direction = 0


    companion object {
        const val DIRECTION_LEFT = 0
        const val DIRECTION_RIGHT = 1
        const val DIRECTION_TOP = 2
        const val DIRECTION_BOTTOM = 3
    }


    fun setDirectionField(@Direction direction: Int) {
        this.direction = direction
    }

    @IntDef(flag = true, value = [DIRECTION_TOP, DIRECTION_BOTTOM, DIRECTION_LEFT, DIRECTION_RIGHT])
    @Retention(AnnotationRetention.SOURCE)
    annotation class Direction


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

        when (direction) {
            DIRECTION_LEFT -> {
                drawCenterTextLeft(canvas)
                drawCenterTextClipLeft(canvas)
            }
            DIRECTION_RIGHT -> {
                drawCenterTextRight(canvas)
                drawCenterTextClipRight(canvas)
            }
        }


    }


    private fun drawCenterTextRight(canvas: Canvas) {
        val text = textContent ?: "默认字体"
        canvas.save()
        paint.apply {
            color = Color.BLACK
            textSize = 40.toFloat()
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
//        val rect = Rect(right.toInt(), 0, width, height)
//        canvas.clipRect(rect)
        canvas.drawText(text, 文字横坐标.toFloat(), 文字纵坐标, paint)
        canvas.restore()
    }


    private fun drawCenterTextClipRight(canvas: Canvas) {
        val text = textContent ?: "默认字体"
        canvas.save()
        paint.apply {
            color = Color.RED
            textSize = 40.toFloat()
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
        val left = 文字横坐标 - measureText / 2 + measureText* (1-percent)
        val right = width

        val rect = Rect(left.toInt(), 0, right.toInt(), height)
        canvas.clipRect(rect)
        canvas.drawText(text, 文字横坐标.toFloat(), 文字纵坐标, paint)
        canvas.restore()
    }



    private fun drawCenterTextLeft(canvas: Canvas) {
        val text = textContent ?: "默认字体"
        canvas.save()
        paint.apply {
            color = Color.BLACK
            textSize = 40.toFloat()
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


    private fun drawCenterTextClipLeft(canvas: Canvas) {
        val text = textContent ?: "默认字体"
        canvas.save()
        paint.apply {
            color = Color.RED
            textSize = 40.toFloat()
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