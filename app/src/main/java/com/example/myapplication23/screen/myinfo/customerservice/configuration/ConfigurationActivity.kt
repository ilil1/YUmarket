package com.example.myapplication23.screen.myinfo.customerservice.configuration


import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.myapplication23.BuildConfig
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityConfigurationBinding
import com.example.myapplication23.databinding.ActivityCsBinding
import com.example.myapplication23.databinding.ActivityCsCenterBinding
import com.example.myapplication23.databinding.FragmentConfigurationBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.home.HomeFragment
import com.example.myapplication23.screen.like.LikeFragment
import com.example.myapplication23.screen.map.MapFragment
import com.example.myapplication23.screen.myinfo.MyInfoFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import com.example.myapplication23.screen.orderlist.OrderListFragment
import org.koin.android.viewmodel.ext.android.viewModel



/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class ConfigurationActivity : BaseActivity<CSViewModel, ActivityCsBinding>() {

    override fun getViewBinding(): ActivityCsBinding
    = ActivityCsBinding.inflate(layoutInflater)

    override val viewModel by viewModel<CSViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun observeData() = with(binding) {
        initViews()
    }



    override fun initViews()  {
        showCSFragment(ConfigurationFragment.newInstance(),ConfigurationFragment.TAG)

    }

        private fun showCSFragment(fragment: Fragment, tag: String) {
                supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment, tag).commit()
        }




}



