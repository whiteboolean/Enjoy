package com.example.enjoy.rxjava_derry.day01

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationSet
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.enjoy.R
import kotlinx.android.synthetic.main.fragment_text.*

const val TEXT_CONTENT = "text"
private const val TAG = "TextFragment"

class TextFragment : Fragment() {

    companion object {
        fun newInstance(itemCount: String): TextFragment = TextFragment().apply {
            arguments = Bundle().apply {
                putString(TEXT_CONTENT, itemCount)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_text, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            val string = this.getString(TEXT_CONTENT)
            view.findViewById<TextView>(R.id.textView4)?.text = string
        }


        Log.e(TAG, button10.height.toString())

        val value = ObjectAnimator.ofFloat(button10, "translationY", 400f).also {
            it.apply {
                duration = 2000
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
            }
        }

        val colorAnim = ObjectAnimator.ofInt(button10, "backgroundColor", 0xFFFF8080.toInt(), 0xFF8080FF.toInt()).also {
            it.apply {
                duration = 3000
                setEvaluator(ArgbEvaluator())
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
            }
        }

        val alphaAnim = ObjectAnimator.ofFloat(button10, "alpha", 1.toFloat(), 0.25f, 1f)
                .apply {
                    duration = 3000
                    repeatMode = ValueAnimator.REVERSE
                    repeatCount = ValueAnimator.INFINITE
                }

        val set = AnimatorSet().apply {
            duration = 5000
        }

        set.playTogether(
                value, colorAnim, alphaAnim

        )





        button10.setOnClickListener {
//            if (!set.isRunning){
//                set.start()
//            }else{
//                set.cancel()
//            }
            performAnimate()

        }
    }


    private fun performAnimate() {
//        ObjectAnimator.ofInt(button10, "width", 400).setDuration(4000).start()
        val obje = ViewWrapper(button10)
        ObjectAnimator.ofInt(obje,"width",500).setDuration(3000).start()
    }

    private fun performAnimate2(){

    }

    inner class ViewWrapper(target: View) {
         var mTarget: View = target

        fun getWidth():Int{
            return mTarget.layoutParams.width
        }

        fun setWidth(width:Int){
            mTarget.layoutParams.width = width
            mTarget.requestLayout()
        }

    }
}