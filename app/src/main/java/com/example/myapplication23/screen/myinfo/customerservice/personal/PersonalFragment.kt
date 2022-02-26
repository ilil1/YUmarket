package com.example.myapplication23.screen.myinfo.customerservice.personal

import com.example.myapplication23.databinding.FragmentPersonalBinding
import com.example.myapplication23.screen.base.BaseFragment

class PersonalFragment: BaseFragment<FragmentPersonalBinding>() {

    override fun getViewBinding(): FragmentPersonalBinding =
        FragmentPersonalBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {

    }

    override fun initViews() {

        binding.configurationLeft.setOnClickListener { back()  }
    }

    private fun back(){

    }

}
