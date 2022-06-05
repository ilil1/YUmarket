package com.example.YUmarket.screen.login

import android.os.Bundle
import com.example.YUmarket.databinding.ActivityLoginBinding
import com.example.YUmarket.screen.base.BaseActivity

class LoginActivity :BaseActivity<ActivityLoginBinding>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun getViewBinding(): ActivityLoginBinding  =
        ActivityLoginBinding.inflate(layoutInflater)

    override fun observeData() {}











}