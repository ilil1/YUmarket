package com.example.myapplication23.screen.myinfo.customerservice


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityCsBinding
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.center.CSCenterFragment
import org.koin.android.viewmodel.ext.android.viewModel



/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class CSActivity : BaseActivity< ActivityCsBinding>() {

    override fun getViewBinding(): ActivityCsBinding
    = ActivityCsBinding.inflate(layoutInflater)


    override fun observeData() = with(binding) {
             //TODO()
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//    }
//
//
//    override fun initViews() = with(binding) {
//        showCSFragment(CSFragment.newInstance(), CSCenterFragment.TAG)
//
//    }
//
//    private fun showCSFragment(fragment: Fragment, tag: String) {
//        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment, tag).commit()
//        }




}






