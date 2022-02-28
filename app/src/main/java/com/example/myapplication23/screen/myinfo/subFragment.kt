package com.example.myapplication23.screen.myinfo

import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentSubBinding
import com.example.myapplication23.screen.base.BaseFragment

class subFragment : BaseFragment<FragmentSubBinding>() {



    override fun getViewBinding(): FragmentSubBinding = FragmentSubBinding.inflate(layoutInflater)

    override fun observeData() {}


    override fun initViews() = with(binding) {
        super.initViews()

       startMyInfo()
    }

    private fun startMyInfo(){
        activity?.let {
            val intent = Intent(context, MyInfoActivity::class.java)
            startActivity(intent)
        }
    }
}