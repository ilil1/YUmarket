package com.example.myapplication23.screen.myinfo.customerservice.personal

import android.content.Intent
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentPersonalBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.MyInfoFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class PersonalFragment : BaseFragment<CSViewModel, FragmentPersonalBinding>() {


    override val viewModel by viewModel<CSViewModel>()

    override fun getViewBinding(): FragmentPersonalBinding =
        FragmentPersonalBinding.inflate(layoutInflater)

    override fun observeData() {
        initViewPager()
    }

    private fun initViewPager() = with(binding) {
        binding.configurationLeft.setOnClickListener { back(MainActivity())  }

    }

    private fun back(activity: MainActivity){
        activity?.let {
            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

    }
    companion object{
        const val TAG = "PersonalFragment"

        fun newInstance() : PersonalFragment {
            return PersonalFragment().apply {

            }
        }
    }
}