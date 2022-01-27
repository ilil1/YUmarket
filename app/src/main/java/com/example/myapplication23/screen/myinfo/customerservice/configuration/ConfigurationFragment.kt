package com.example.myapplication23.screen.myinfo.customerservice.configuration

import com.example.myapplication23.BuildConfig
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentConfigurationBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.MyInfoFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class ConfigurationFragment : BaseFragment<CSViewModel, FragmentConfigurationBinding>() {

    val versionNumber = BuildConfig.VERSION_NAME

    override val viewModel by viewModel<CSViewModel>()

    override fun getViewBinding(): FragmentConfigurationBinding =
        FragmentConfigurationBinding.inflate(layoutInflater)

    override fun observeData() {
        initViewPager()
    }

    private fun initViewPager() = with(binding){
        binding.versionCode.text = versionNumber
        binding.configurationLeft.setOnClickListener { showMyinfo(MainActivity()) }
    }

    private fun showMyinfo(activity: MainActivity){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MyInfoFragment.newInstance(),"myinfo")
            .commit()

    }

    companion object{
        const val TAG = "ConfigurationFragment"

        fun newInstance() : ConfigurationFragment {
            return ConfigurationFragment().apply {

            }
        }
    }
}