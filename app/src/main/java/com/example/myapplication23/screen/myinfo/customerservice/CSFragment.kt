package com.example.myapplication23.screen.myinfo.customerservice

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

import androidx.core.view.isVisible
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentCsBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.MyInfoFragment
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment
import com.example.myapplication23.widget.adapter.CSListFragmentPagerAdapter

import org.koin.android.viewmodel.ext.android.viewModel

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
       orderChipGroupCs.isVisible = false
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
        }


            viewPagerCs.adapter = viewPagerAdapter

            viewPagerCs.offscreenPageLimit = 1


            binding.intentmyinfo.setOnClickListener {
                showMyinfo(MainActivity())
            }




        }




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
