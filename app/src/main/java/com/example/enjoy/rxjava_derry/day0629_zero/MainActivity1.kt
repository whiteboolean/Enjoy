package com.example.enjoy.rxjava_derry.day0629_zero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.example.enjoy.R
import com.example.enjoy.databinding.ActivityMain7Binding
import com.example.enjoy.databinding.ActivityMain8Binding
import com.example.enjoy.rxjava_derry.utils.a
import com.frame.net_work_base.http.IDataListener
import com.frame.net_work_base.http.NetFrameWork
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main8.*
import kotlinx.android.synthetic.main.content_main.view.*


//kotlin 泛型
/*
T<? extends B> 下界  T<out B> 协变 生产者
T<? super B> 上界  T<in B> 逆变 消费者
 */

class MainActivity1 : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMain8Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain8Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel = ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(MainViewModel::class.java)
        viewModel.getMutableLiveDataList()


        val view =LayoutInflater.from(this).inflate(R.layout.content_view,co,false)

//        include.ll.addView(view)
//            include.ll.addView(view)
            binding.include.ll.addView(view)
    }



}


