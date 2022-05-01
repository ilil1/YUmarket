package com.example.YUmarket.screen.map

import com.example.YUmarket.databinding.FragmentMapBinding
import com.example.YUmarket.screen.base.BaseFragment

class MapFragment : BaseFragment<FragmentMapBinding>() {

    override fun getViewBinding(): FragmentMapBinding =
        FragmentMapBinding.inflate(layoutInflater)

    override fun observeData() {
    }

    companion object {
        const val TAG = "MapFragment"

        fun newInstance() = MapFragment()
    }


}