package com.example.myapplication23.screen.myinfo.customerservice.terms

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentTermsBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment


class TermsFragment : BaseFragment<FragmentTermsBinding>() {

    private fun back(){

    }

    override fun getViewBinding(): FragmentTermsBinding =
        FragmentTermsBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {

    }

    override fun initViews() {

        binding.configurationLeft.setOnClickListener {    view?.findViewById<ImageView>(R.id.back)!!.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_termsFragment_to_myInfoFragment) }
        }  }

    }


}