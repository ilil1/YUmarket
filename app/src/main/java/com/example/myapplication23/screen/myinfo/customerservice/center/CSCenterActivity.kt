package com.example.myapplication23.screen.myinfo.customerservice.center

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityCsCenterBinding
import com.example.myapplication23.screen.base.BaseActivity

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */
class CSCenterActivity : BaseActivity<ActivityCsCenterBinding>() {

    override fun getViewBinding(): ActivityCsCenterBinding = ActivityCsCenterBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {
        //TODO()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    override fun initViews() = with(binding) {
       // CSCenterFragment(CSCenterFragment.newInstance(), CSFragment.TAG)

    }

    private fun CSCenterFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment, tag).commit()
    }
}
