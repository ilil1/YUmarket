package com.example.YUmarket.screen.store

import com.example.YUmarket.databinding.FragmentStoreBinding
import com.example.YUmarket.screen.base.BaseFragment

class StoreFragment : BaseFragment<FragmentStoreBinding>() {



    override fun getViewBinding(): FragmentStoreBinding =
        FragmentStoreBinding.inflate(layoutInflater)

    override fun observeData() {}



}