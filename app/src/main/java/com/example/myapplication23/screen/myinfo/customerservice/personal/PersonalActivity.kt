package com.example.myapplication23.screen.myinfo.customerservice.personal

import android.content.Intent
import android.os.Bundle
import com.example.myapplication23.databinding.ActivityPersonalBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class PersonalActivity: BaseActivity<ActivityPersonalBinding>() {

    override fun getViewBinding(): ActivityPersonalBinding =
        ActivityPersonalBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    override fun initViews() {

        binding.configurationLeft.setOnClickListener { back()  }
    }

    private fun back(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

}
