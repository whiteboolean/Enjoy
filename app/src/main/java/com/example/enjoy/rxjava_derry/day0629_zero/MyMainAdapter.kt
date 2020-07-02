package com.example.enjoy.rxjava_derry.day0629_zero

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enjoy.R
import kotlinx.android.synthetic.main.activity_main3.view.*

class MyMainAdapter(val list: MutableList<Fruit>?, val context: Context) : RecyclerView.Adapter<MyMainAdapter.Companion.MyHolder>() {

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.activity_list_item, null)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        list?.get(position)?.imageView?.let { holder.imageView.setBackgroundResource(it) }
        holder.textView.text = list?.get(position)?.price
    }


    companion object {
        class MyHolder(val view: View) : RecyclerView.ViewHolder(view) {
            var textView = view.findViewById<TextView>(android.R.id.text1)
            var imageView = view.findViewById<ImageView>(android.R.id.icon)
        }
    }
}