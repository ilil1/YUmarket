package com.example.myapplication23.screen.myinfo.customerservice.personal

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
        binding.configurationLeft.setOnClickListener { showMyinfo(MainActivity())  }

    }

    private fun showMyinfo(activity: MainActivity){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MyInfoFragment.newInstance(),"myinfo")
            .commit()

    }
    companion object{
        const val TAG = "PersonalFragment"

        fun newInstance() : PersonalFragment {
            return PersonalFragment().apply {

            }
        }
    }
}