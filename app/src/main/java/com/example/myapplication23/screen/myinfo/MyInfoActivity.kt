package com.example.myapplication23.screen.myinfo


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityMyinfoBinding
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.terms.TermsFragment



class MyInfoActivity : BaseActivity<ActivityMyinfoBinding>() {



    override fun getViewBinding(): ActivityMyinfoBinding =
        ActivityMyinfoBinding.inflate(layoutInflater)

    override fun observeData() {

    }


    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initViews() = with(binding) {
    super.initViews()



    //showMyInfoFragment(MyInfoFragment.newInstance(),MyInfoFragment.TAG)


    }

    private fun showMyInfoFragment(fragment: MyInfoFragment, tag: String) {
        supportFragmentManager.beginTransaction().add(R.id.cs_host_fragment,fragment, tag).commit()
    }



}