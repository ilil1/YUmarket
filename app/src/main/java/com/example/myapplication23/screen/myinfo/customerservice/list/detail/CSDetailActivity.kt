package com.example.myapplication23.screen.myinfo.customerservice.list.detail

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityDetailBinding
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSActivity
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment
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

    uturn.setOnClickListener {
       changeFragment()
        finish()
    }
    }




    private fun changeFragment(){
     val intent = Intent(this,CSActivity::class.java)
        startActivity(intent)

    }


}