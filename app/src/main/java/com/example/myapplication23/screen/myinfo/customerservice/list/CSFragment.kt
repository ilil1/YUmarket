package com.example.myapplication23.screen.myinfo.customerservice.list

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

import android.content.Intent
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentCsBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.MyInfoFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import com.example.myapplication23.util.mapper.ViewHolderMapper.map
import com.example.myapplication23.util.mapper.ViewHolderMapperCS
import com.example.myapplication23.widget.adapter.CSListFragmentPagerAdapter
import okhttp3.internal.notify

import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.experimental.property.inject
import org.koin.ext.getOrCreateScope

class CSFragment : BaseFragment<CSViewModel, FragmentCsBinding>() {

    private lateinit var viewPagerAdapter: CSListFragmentPagerAdapter

    override val viewModel by viewModel<CSViewModel>()

    override fun getViewBinding(): FragmentCsBinding =
        FragmentCsBinding.inflate(layoutInflater)

    override fun observeData() {
        initViewPager()

        //TODO(로그인 확인) ->Success->

    }


    private fun initViewPager() = with(binding) {
       orderChipGroupCs.isVisible = true
        binding.CSTextView.text = "고객센터"


        if (::viewPagerAdapter.isInitialized.not()) {
            val csCategory = CSCategory.values()

            val csListFragmentList = csCategory.map {
                CSListFragment.newInstance(it)
            }

            viewPagerAdapter = CSListFragmentPagerAdapter(
                this@CSFragment,
                csListFragmentList

            )


            viewPagerCs.adapter = viewPagerAdapter

            viewPagerCs.offscreenPageLimit = csCategory.size


            binding.intentmyinfo.setOnClickListener {
                showMyinfo(MainActivity())
            }



//            binding.chipLogin.setOnCloseIconClickListener { chipData(CSCategory.LOGIN)
//
//
//            }
        }
    }

//    private fun chipData(csCategory:CSCategory) = with(binding){
//        val loginCategory = CSCategory.values()
//        val loginList = loginCategory.map {
//
//        }
//
//        viewPagerAdapter = CSListFragmentPagerAdapter(
//            this@CSFragment,
//
//        )
//        viewPagerCs.adapter = viewPagerAdapter
//
//        viewPagerCs.offscreenPageLimit = 1
//    }



    private fun showMyinfo(activity: MainActivity){
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer,MyInfoFragment.newInstance(),"myinfo")
                .commit()

    }


        companion object {
        const val TAG = "CSFragment"

        fun newInstance() : CSFragment {
            return CSFragment().apply {

            }
        }
    }
    }
