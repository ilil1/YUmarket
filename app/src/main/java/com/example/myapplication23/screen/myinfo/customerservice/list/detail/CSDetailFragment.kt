//package com.example.myapplication23.screen.myinfo.customerservice.list.detail
//
//import android.content.Context
//import android.content.Intent
//import androidx.lifecycle.ViewModel
//import com.example.myapplication23.databinding.FragmentCsDetailBinding
//import com.example.myapplication23.model.customerservicelist.CSModel
//import com.example.myapplication23.screen.base.BaseFragment
//import com.example.myapplication23.screen.myinfo.customerservice.CSCenterFragment
//import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment
//import org.koin.android.viewmodel.ext.android.viewModel
//
//
//class CSDetailFragment : BaseFragment<CSDetailViewModel,FragmentCsDetailBinding>() {
//
//    override val viewModel by viewModel<CSDetailViewModel>()
//
//
//    override fun getViewBinding(): FragmentCsDetailBinding =
//        FragmentCsDetailBinding.inflate(layoutInflater)
//
//
//    override fun observeData() {
//        TODO("Not yet implemented")
//    }
//
//    companion object {
//        const val TAG = "CSDetailFragment"
//
//        fun newInstance(context: Context, csModel: CSModel): CSDetailFragment {
//            return CSDetailFragment().apply {
//
//            }
//        }
//
//    }
//}