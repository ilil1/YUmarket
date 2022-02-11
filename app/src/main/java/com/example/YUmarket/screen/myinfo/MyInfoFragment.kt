package com.example.YUmarket.screen.myinfo

import com.example.YUmarket.databinding.FragmentMyInfoBinding
import com.example.YUmarket.screen.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MyInfoFragment : BaseFragment<FragmentMyInfoBinding>() {
    override fun getViewBinding() =
        FragmentMyInfoBinding.inflate(layoutInflater)
}