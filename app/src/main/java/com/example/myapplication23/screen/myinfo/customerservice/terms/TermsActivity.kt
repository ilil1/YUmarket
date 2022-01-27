package com.example.myapplication23.screen.myinfo.customerservice.terms

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.ActivityTermsBinding
import com.example.myapplication23.screen.base.BaseActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class TermsActivity : BaseActivity<CSViewModel,ActivityTermsBinding>() {



    override val viewModel by viewModel<CSViewModel>()


    override fun getViewBinding(): ActivityTermsBinding =
        ActivityTermsBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    override fun initViews() {
        showTermsFragment(TermsFragment.newInstance(), TermsFragment.TAG)

    }

    private fun showTermsFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment, tag).commit()
    }
}