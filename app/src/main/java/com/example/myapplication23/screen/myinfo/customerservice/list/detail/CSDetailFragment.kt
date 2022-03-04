package com.example.myapplication23.screen.myinfo.customerservice.list.detail

import android.content.Intent
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentDetailBinding
import com.example.myapplication23.model.customerservicelist.ImageData
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory


class CSDetailFragment : BaseFragment<FragmentDetailBinding>() {


    override fun getViewBinding(): FragmentDetailBinding =
        FragmentDetailBinding.inflate(layoutInflater)

    override fun observeData() {

    }

    override fun initViews() = with(binding) {
        super.initViews()

    val csData = arguments?.getParcelable<ImageData>("data")

    title.text = csData?.csTitle.toString()
    author.text = csData?.csAuthor.toString()
    content.text = csData?.csContent.toString()

    uturn.setOnClickListener {
       changeFragment()


        view?.let{it1 ->
            Navigation.findNavController(it1).popBackStack()
        }
     }

    }


    private fun changeFragment(){
        view?.let { it1 ->
            Navigation.findNavController(it1)
                .navigate(R.id.action_CSDetailFragment_to_CSFragment)
        }

    }


}


