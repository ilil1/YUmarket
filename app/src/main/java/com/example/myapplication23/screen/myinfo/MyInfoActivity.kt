package com.example.myapplication23.screen.myinfo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityMyinfoBinding
import com.example.myapplication23.screen.base.BaseActivity

class MyInfoActivity : BaseActivity<ActivityMyinfoBinding>() {



    override fun getViewBinding(): ActivityMyinfoBinding =
        ActivityMyinfoBinding.inflate(layoutInflater)

    override fun observeData() {

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initViews() {
        super.initViews()
        showMyInfoFragment(MyInfoFragment.newInstance(),MyInfoFragment.TAG)
    }

    private fun showMyInfoFragment(fragment: MyInfoFragment, tag: String) {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment, tag).commit()
    }




}