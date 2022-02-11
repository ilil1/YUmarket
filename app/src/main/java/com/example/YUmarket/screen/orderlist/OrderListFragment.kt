package com.example.YUmarket.screen.orderlist

import com.example.YUmarket.databinding.FragmentOrderListBinding
import com.example.YUmarket.screen.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class OrderListFragment : BaseFragment<FragmentOrderListBinding>() {
    override fun getViewBinding() =
        FragmentOrderListBinding.inflate(layoutInflater)
}