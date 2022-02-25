package com.example.myapplication23.screen.orderlist

import com.example.myapplication23.databinding.FragmentOrderListBinding
import com.example.myapplication23.screen.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class OrderListFragment : BaseFragment<FragmentOrderListBinding>() {

    override fun getViewBinding() =
        FragmentOrderListBinding.inflate(layoutInflater)

    override fun observeData() {
    }

    companion object {
        const val TAG = "OrderListFragment"

        fun newInstance(): OrderListFragment {
            return OrderListFragment()
        }
    }
}