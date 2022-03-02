package com.example.myapplication23.screen.myinfo.customerservice

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentCsBinding
import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.model.customerservicelist.ImageData
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.email.EmailFragment
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListViewModel
import com.example.myapplication23.screen.myinfo.customerservice.list.detail.CSDetailFragment
import com.example.myapplication23.util.provider.ResoucesProvider
import com.example.myapplication23.widget.adapter.HomeListFragmentPagerAdapter
import com.example.myapplication23.widget.adapter.ModelRecyclerAdapter
import com.example.myapplication23.widget.adapter.listener.customerservice.CSModelListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CSFragment : BaseFragment<FragmentCsBinding>() {

    private lateinit var viewAdapter: HomeListFragmentPagerAdapter


    override fun getViewBinding(): FragmentCsBinding =
        FragmentCsBinding.inflate(layoutInflater)

    override fun observeData(){
    }




    override fun initViews() = with(binding) {
        super.initViews()
        binding.CSTextView.text = "고객센터"

        if (::viewAdapter.isInitialized.not()) {
            val csCategory = CSCategory.values()

            val CSListfragmnet = csCategory.map {
                CSListFragment.newInstance(it)
            }

            viewPagerCs.adapter = HomeListFragmentPagerAdapter(
                this@CSFragment,
                CSListfragmnet
            )

        }



        binding.intentmyinfo.setOnClickListener {
                view?.let { it1 ->
                    Navigation.findNavController(it1)
                        .navigate(R.id.action_CSFragment_to_myInfoFragment)

            }
            view?.findViewById<FloatingActionButton>(R.id.editBtn)!!.setOnClickListener {
                view?.let { it1 ->
                    Navigation.findNavController(it1)
                        .navigate(R.id.action_CSFragment_to_emailFragment) }
            }


                binding.back.setOnClickListener {
                    back()
                }


        }
    }



    private fun back() {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_CSFragment_to_CSCenterFragment)
        }
    }


    }



