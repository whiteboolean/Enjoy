package com.example.enjoy.rxjava_derry.day0629_zero

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.example.enjoy.R
import com.example.enjoy.databinding.ActivityMain7Binding
import com.example.enjoy.rxjava_derry.utils.a
import com.google.android.material.snackbar.Snackbar


//kotlin 泛型
/*
T<? extends B> 下界  T<out B> 协变 生产者
T<? super B> 上界  T<in B> 逆变 消费者
 */

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMain7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel = ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(MainViewModel::class.java)

        viewModel.getMutableLiveDataList()
        viewModel.list.observe(this@MainActivity, Observer {
            binding.include.recyclerView.adapter = MyMainAdapter(it, this@MainActivity)
        })

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }



//        Math.max()

    }

    fun main(){




    }


    fun lenMethod(vararg value: Int) {
        for (i in value) {
            print(i)
        }
    }


}


