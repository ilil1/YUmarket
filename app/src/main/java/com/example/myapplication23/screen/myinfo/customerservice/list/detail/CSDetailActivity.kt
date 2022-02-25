package com.example.myapplication23.screen.myinfo.customerservice.list.detail

import android.content.Intent
import com.example.myapplication23.databinding.ActivityDetailBinding
import com.example.myapplication23.model.customerservicelist.ImageData
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import com.example.myapplication23.screen.myinfo.customerservice.center.CSCenterActivity
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment
import org.koin.android.viewmodel.ext.android.viewModel


class CSDetailActivity :BaseActivity<ActivityDetailBinding>() {


    override fun getViewBinding(): ActivityDetailBinding =
        ActivityDetailBinding.inflate(layoutInflater)

    override fun observeData() {

    }

    override fun initViews() = with(binding) {
        super.initViews()

    val csData = intent?.getParcelableExtra<ImageData>(CSListFragment.CS_CATEGORY_KEY)

    title.text = csData?.csTitle
    author.text = csData?.csAuthor
    content.text = csData?.csContent

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