package com.example.myapplication23.screen.myinfo.customerservice.list.detail

import android.content.Intent
import com.example.myapplication23.databinding.FragmentDetailBinding
import com.example.myapplication23.model.customerservicelist.ImageData
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSFragment
import com.example.myapplication23.screen.myinfo.customerservice.center.CSCenterActivity
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment


class CSDetailFragment : BaseFragment<FragmentDetailBinding>() {


    override fun getViewBinding(): FragmentDetailBinding =
        FragmentDetailBinding.inflate(layoutInflater)

    override fun observeData() {

    }

    override fun initViews() = with(binding) {
        super.initViews()

    val csData = requireActivity().intent?.getParcelableExtra<ImageData>(CSListFragment.CS_CATEGORY_KEY)

    title.text = csData?.csTitle
    author.text = csData?.csAuthor
    content.text = csData?.csContent

    uturn.setOnClickListener {
       changeFragment()

     }
    }

    private fun changeFragment(){
    val intent = Intent(context, CSCenterActivity::class.java)
    startActivity(intent)
    }


}