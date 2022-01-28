package com.example.myapplication23.screen.myinfo.customerservice.list.detail

import com.example.myapplication23.databinding.ActivityDetailBinding
import com.example.myapplication23.screen.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel


class CSDetailActivity :BaseActivity<CSDetailViewModel,ActivityDetailBinding>() {

    override val viewModel by viewModel<CSDetailViewModel>()


    override fun getViewBinding(): ActivityDetailBinding =
        ActivityDetailBinding.inflate(layoutInflater)

    override fun observeData() {
        initViews()
    }

    override fun initViews() = with(binding) {
    title.text = intent.getStringExtra("CSTitle")
    author.text = intent.getStringExtra("CSAuthor")
    content.text = intent.getStringExtra("CSContent")

    }
}