package com.frame.july_myview.what_is_view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frame.july_myview.R
import com.frame.july_myview.databinding.ActivityDemo1Binding
import kotlinx.android.synthetic.main.content_layout.view.*

private const val TAG = "DemoActivity_1"

class DemoActivity1 : AppCompatActivity() {


    lateinit var binding: ActivityDemo1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemo1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: ")
        initView()
    }

    private fun initView() {

        val screenWidth = MyUtils.getScreenMetrics(this)?.widthPixels
        val screenHeight = MyUtils.getScreenMetrics(this)?.heightPixels
        for (i in 0 until 3) {
            val layout = layoutInflater.inflate(R.layout.content_layout, binding.container, false) as ViewGroup
            layout.layoutParams.width = screenWidth ?: screenWidth ?: 1
            val title = layout.title
            title.text  = "page${i+1}"
            layout.setBackgroundColor(Color.rgb(255/(i+1),255/(i+1),0))
            createList(layout)
            binding.container.addView(layout)
        }

    }

    private fun createList(layout: ViewGroup) {

        val datas = mutableListOf<String>()
        for (i in 0 until 50){
            datas.add("name $i")
        }


        val adapter = ArrayAdapter<String>(this,R.layout.content_list_item,R.id.name,datas )
        layout.list.adapter = adapter
        layout.list .setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "click_item", Toast.LENGTH_SHORT).show()
        }


    }

}
