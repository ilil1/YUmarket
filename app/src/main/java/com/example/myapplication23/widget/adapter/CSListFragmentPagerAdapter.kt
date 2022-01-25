package com.example.myapplication23.widget.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment

/**
 * @주 허희태
 * @부 김건우 정남진 김도엽 배은호
 * @since
 * @throws
 * @description
 */



class CSListFragmentPagerAdapter (
    fragement : Fragment,
    private val fragementList: List<CSListFragment>
    ): FragmentStateAdapter(fragement){

    override fun getItemCount() = 1


    override fun createFragment(position: Int) = fragementList[position]
}