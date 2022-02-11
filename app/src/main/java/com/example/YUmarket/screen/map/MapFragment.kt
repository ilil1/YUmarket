package com.example.YUmarket.screen.map

import com.example.YUmarket.databinding.FragmentMapBinding
import com.example.YUmarket.screen.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MapFragment : BaseFragment<FragmentMapBinding>() {
    override fun getViewBinding(): FragmentMapBinding =
        FragmentMapBinding.inflate(layoutInflater)

}