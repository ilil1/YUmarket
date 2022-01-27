package com.example.myapplication23.screen.myinfo.customerservice.terms

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
        binding.configurationLeft.setOnClickListener { showMyinfo(MainActivity())  }
    }

    private fun showMyinfo(activity: MainActivity){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MyInfoFragment.newInstance(),"myinfo")
            .commit()

    }
    companion object{
        const val TAG = "TermsFragment"

        fun newInstance() : TermsFragment {
            return TermsFragment().apply {

            }
        }
    }
}