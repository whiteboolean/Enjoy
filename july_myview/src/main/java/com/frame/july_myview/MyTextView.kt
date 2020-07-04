package com.frame.july_myview

import android.content.Context
import android.util.AttributeSet
import android.widget.Scroller
import androidx.appcompat.widget.AppCompatTextView

class MyTextView @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null,
                                           defStyleAttr: Int = 0) : AppCompatTextView(context, attrs, defStyleAttr) {


    private val scroller:Scroller = Scroller(context)


    //缓慢移动到指定位置
    //scroller.startScroll -> onDraw -> invalidate ->改变scrollX,scrollY ->computeScroll -> postInvalidate ->computerScroll
    public fun smoothScrollTo( destX:Int ,destY:Int){
        val deltaX = destX - scrollX
        val deltaY = destY - scrollY
        scroller.startScroll(scrollX,scrollY,deltaX,deltaY,1000)
        invalidate()
    }



    override fun computeScroll() {
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.currX,scroller.currY)
            postInvalidate()
        }
    }


}