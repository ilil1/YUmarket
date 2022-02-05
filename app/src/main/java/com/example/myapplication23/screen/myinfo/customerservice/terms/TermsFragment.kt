package com.example.myapplication23.screen.myinfo.customerservice.terms

import android.content.Intent
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentTermsBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.MyInfoFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class TermsFragment : BaseFragment<CSViewModel,FragmentTermsBinding>() {


    override val viewModel by viewModel<CSViewModel>()

    override fun getViewBinding(): FragmentTermsBinding =
        FragmentTermsBinding.inflate(layoutInflater)

    override fun observeData() {
        initViewPager()
    }

    private fun initViewPager() = with(binding) {
        binding.configurationLeft.setOnClickListener { back(MainActivity())  }
        //binding.textView.text = getString(R.string.configuration)
    }

    private fun back(activity: MainActivity){
        activity?.let {
            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

    }
    companion object{
        const val TAG = "TermsFragment"

        fun newInstance() : TermsFragment {
            return TermsFragment().apply {

            }
        }
    }
}