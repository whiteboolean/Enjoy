package com.example.enjoy.rxjava_derry.day01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.enjoy.R

const val TEXT_CONTENT = "text"

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
    }
}