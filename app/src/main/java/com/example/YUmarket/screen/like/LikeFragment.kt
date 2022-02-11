package com.example.YUmarket.screen.like

import com.example.YUmarket.databinding.FragmentLikeBinding
import com.example.YUmarket.screen.base.BaseFragment

class LikeFragment
    : BaseFragment<FragmentLikeBinding>() {

    override fun getViewBinding(): FragmentLikeBinding =
        FragmentLikeBinding.inflate(layoutInflater)
}