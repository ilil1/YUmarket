package com.example.myapplication23.screen.myinfo.customerservice.list.detail

import android.content.Intent
import com.example.myapplication23.databinding.ActivityDetailBinding
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import com.example.myapplication23.screen.myinfo.customerservice.center.CSCenterActivity
import org.koin.android.viewmodel.ext.android.viewModel


class CSDetailActivity :BaseActivity<CSViewModel,ActivityDetailBinding>() {

    override val viewModel by viewModel<CSViewModel>()


    override fun getViewBinding(): ActivityDetailBinding =
        ActivityDetailBinding.inflate(layoutInflater)

    override fun observeData() {

    }

    override fun initViews() = with(binding) {
        super.initViews()
    title.text = intent.getStringExtra("CSTitle")
    author.text = intent.getStringExtra("CSAuthor")
    content.text = intent.getStringExtra("CSContent")

    uturn.setOnClickListener {
       changeFragment()
        finish()
     }
    }

    private fun changeFragment(){
     val intent = Intent(this, CSCenterActivity::class.java)
        startActivity(intent)

    }


}