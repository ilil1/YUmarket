package com.example.myapplication23.screen.myinfo.customerservice.terms

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityTermsBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class TermsActivity : BaseActivity<ActivityTermsBinding>() {

    private fun back(){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
    }

    override fun getViewBinding(): ActivityTermsBinding =
        ActivityTermsBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    override fun initViews() {
        binding.configurationLeft.setOnClickListener { back()  }

    }


}