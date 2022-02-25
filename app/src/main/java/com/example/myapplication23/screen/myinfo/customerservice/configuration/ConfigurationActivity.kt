package com.example.myapplication23.screen.myinfo.customerservice.configuration


import android.content.Intent
import android.os.Bundle
import com.example.myapplication23.BuildConfig
import com.example.myapplication23.databinding.ActivityConfigurationBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import org.koin.android.viewmodel.ext.android.viewModel



/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class ConfigurationActivity : BaseActivity<ActivityConfigurationBinding>() {

    val versionNumber = BuildConfig.VERSION_NAME

    override fun getViewBinding(): ActivityConfigurationBinding
    = ActivityConfigurationBinding.inflate(layoutInflater)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun observeData() = with(binding) {
        initViews()
    }

    private fun back(){
    var intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    finish()
    }


    override fun initViews() =with(binding)  {
        binding.versionCode.text = versionNumber
        binding.configurationLeft.setOnClickListener{
            back()
            finish()
        }
    }

}



