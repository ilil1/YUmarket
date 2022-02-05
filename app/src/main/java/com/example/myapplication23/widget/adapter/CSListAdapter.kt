package com.example.myapplication23.widget.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */



class CSListAdapter (
    fragement : Fragment,
    private val fragementList: List<CSListFragment>
    ): FragmentStateAdapter(fragement){

    override fun getItemCount() = 1


    override fun createFragment(position: Int) = fragementList[position]
}