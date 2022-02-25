package com.example.myapplication23.screen.myinfo.customerservice.terms

import android.content.Intent
import android.os.Bundle
import com.example.myapplication23.databinding.FragmentTermsBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment


class TermsFragment : BaseFragment<FragmentTermsBinding>() {

    private fun back(){

    }

    override fun getViewBinding(): FragmentTermsBinding =
        FragmentTermsBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {

    }

    override fun initViews() {
        binding.configurationLeft.setOnClickListener { back()  }

    }


}