package com.example.myapplication23.screen.myinfo.customerservice.personal

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityPersonalBinding
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import com.example.myapplication23.screen.myinfo.customerservice.terms.TermsFragment
import org.koin.android.viewmodel.ext.android.viewModel

class PersonalActivity: BaseActivity<CSViewModel, ActivityPersonalBinding>() {



    override val viewModel by viewModel<CSViewModel>()


    override fun getViewBinding(): ActivityPersonalBinding =
        ActivityPersonalBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    override fun initViews() {
        showPersonalFragment(PersonalFragment.newInstance(), PersonalFragment.TAG)

    }

    private fun showPersonalFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment, tag).commit()
    }
}
