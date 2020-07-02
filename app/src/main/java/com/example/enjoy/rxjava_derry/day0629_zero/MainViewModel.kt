package com.example.enjoy.rxjava_derry.day0629_zero

import android.app.Application
import android.util.MutableDouble
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.enjoy.R
import kotlinx.android.synthetic.main.activity_main7.view.*

data class Fruit(val imageView: Int, val price: String)

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val list: MutableLiveData<MutableList<Fruit>> = MutableLiveData(mutableListOf())

    public fun getMutableLiveDataList() {
        val listData = mutableListOf<Fruit>()
        val fruit = Fruit(R.mipmap.ic_launcher, "2")
        listData.apply {
            for (i in 0..57) {
                add(fruit)
            }
        }
        list.postValue(listData)
    }


}