package com.example.myapplication23.screen.myinfo


import android.os.Bundle
import com.example.myapplication23.databinding.ActivityMyinfoBinding
import com.example.myapplication23.screen.base.BaseActivity


class MyInfoActivity : BaseActivity<ActivityMyinfoBinding>() {


    override fun getViewBinding(): ActivityMyinfoBinding =
        ActivityMyinfoBinding.inflate(layoutInflater)

    override fun observeData() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initViews() = with(binding) {
        super.initViews()


    }

}