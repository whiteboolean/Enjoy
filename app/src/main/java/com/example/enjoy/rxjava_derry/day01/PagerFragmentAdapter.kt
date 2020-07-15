package com.example.enjoy.rxjava_derry.day01

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerFragmentAdapter(fm:FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fm,lifecycle) {

    private  var fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }

    fun addFragment(fragment:Fragment){
        fragments.add(fragment)
    }

    override fun createFragment(position: Int): Fragment {
      return fragments[position]
    }



}