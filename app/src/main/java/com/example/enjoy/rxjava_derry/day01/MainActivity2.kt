package com.example.enjoy.rxjava_derry.day01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.enjoy.R
import com.frame.july_myview.zero_custom_view.MyTextViewCopy
import kotlinx.android.synthetic.main.activity_main10.*

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        val pagerFragmentAdapter = PagerFragmentAdapter(supportFragmentManager, lifecycle)
        val fragment1 = TextFragment.newInstance("新闻")
        val fragment2 = TextFragment.newInstance("首页")
        val fragment3 = TextFragment.newInstance("头条")
        val fragment4 = TextFragment.newInstance("热点")

        pagerFragmentAdapter.apply {
            addFragment(fragment1)
            addFragment(fragment2)
            addFragment(fragment3)
            addFragment(fragment4)
        }
        val list = mutableListOf<MyTextViewCopy>(tvCopy1, tvCopy2, tvCopy3, tvCopy4)
        tvCopy1.textContent = "新闻"
        tvCopy2.textContent = "首页"
        tvCopy3.textContent = "头条"
        tvCopy4.textContent = "热点"

        viewPager2.adapter = pagerFragmentAdapter
        var lastPosition = 0
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                println("position:$position")
                println("positionOffset:$positionOffset")
                println("positionOffsetPixels:$positionOffsetPixels")


                list[position].setDirectionField(MyTextViewCopy.DIRECTION_RIGHT)
                list[position].setPercents(1-positionOffset)

                if (position+1<list.size){
                    list[position+1].setDirectionField(MyTextViewCopy.DIRECTION_LEFT)
                    list[position+1].setPercents(positionOffset)
                }

            }
        })
    }
}