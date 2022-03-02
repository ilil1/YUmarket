package com.example.myapplication23.screen.myinfo.customerservice.list.detail

import android.content.Intent
import android.os.Bundle
import com.example.myapplication23.databinding.FragmentDetailBinding
import com.example.myapplication23.model.customerservicelist.ImageData
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSFragment
import com.example.myapplication23.screen.myinfo.customerservice.center.CSCenterActivity
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment
import org.koin.ext.getOrCreateScope


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

     }
    }






    private fun changeFragment(){
    val intent = Intent(context, CSCenterActivity::class.java)
    startActivity(intent)
    }

    companion object {
        const val CS_CATEGORY_KEY = "CSCategoryKey"
        fun newInstance(csCategory: CSCategory): CSDetailFragment {
            val bundle = Bundle().apply {
                putSerializable(CS_CATEGORY_KEY, csCategory)
            }

            return CSDetailFragment().apply {
                arguments = bundle
            }
        }
    }
}


