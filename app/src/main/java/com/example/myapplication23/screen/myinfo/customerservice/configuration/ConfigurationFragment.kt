package com.example.myapplication23.screen.myinfo.customerservice.configuration


import com.example.myapplication23.BuildConfig
import com.example.myapplication23.databinding.FragmentConfigurationBinding
import com.example.myapplication23.screen.base.BaseFragment



/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class ConfigurationFragment : BaseFragment<FragmentConfigurationBinding>() {

    val versionNumber = BuildConfig.VERSION_NAME

    override fun getViewBinding(): FragmentConfigurationBinding
    = FragmentConfigurationBinding.inflate(layoutInflater)




    override fun observeData() = with(binding) {
        initViews()
    }

    private fun back(){}



    override fun initViews() =with(binding)  {
        binding.versionCode.text = versionNumber
        binding.configurationLeft.setOnClickListener{ back() }
    }

}



