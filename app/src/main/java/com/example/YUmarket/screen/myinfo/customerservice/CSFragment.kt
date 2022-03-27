package com.example.YUmarket.screen.myinfo.customerservice

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */


import android.os.Bundle
import androidx.core.view.get
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.YUmarket.R
import com.example.YUmarket.databinding.FragmentCsBinding
import com.example.YUmarket.model.customerservicelist.ImageData
import com.example.YUmarket.model.customerservicelist.CSModel
import com.example.YUmarket.screen.base.BaseFragment
import com.example.YUmarket.screen.myinfo.customerservice.list.CSCategory
import com.example.YUmarket.screen.myinfo.customerservice.list.CSListFragment
import com.example.YUmarket.screen.myinfo.customerservice.list.CSListViewModel
import com.example.YUmarket.util.provider.ResoucesProvider
import com.example.YUmarket.widget.adapter.HomeListFragmentPagerAdapter
import com.example.YUmarket.widget.adapter.ModelRecyclerAdapter
import com.example.YUmarket.widget.adapter.listener.customerservice.CSModelListener
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class CSFragment : BaseFragment<FragmentCsBinding>() {

    private lateinit var viewAdapter : HomeListFragmentPagerAdapter



    override fun getViewBinding(): FragmentCsBinding =
        FragmentCsBinding.inflate(layoutInflater)

    override fun observeData()  {}


    override fun initViews() = with(binding) {
        super.initViews()

        CSTextView.text = "고객센터"

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
        viewPagerCs.offscreenPageLimit = 1



        intentmyinfo.setOnClickListener {
            intentMyinfo()
            doubleBackStack()
        }

        editBtn.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_CSFragment_to_emailFragment)
            }


        }
        csback.setOnClickListener {
            backMove()
        }
    }

    private fun intentMyinfo() {
        view?.let { it1 ->
            Navigation.findNavController(it1)
                .navigate(R.id.action_CSFragment_to_myInfoFragment)

        }
    }

    private fun doubleBackStack() {
        view?.let { it1 ->
            Navigation.findNavController(it1).popBackStack()
        }
        view?.let { it1 ->
            Navigation.findNavController(it1).popBackStack()
        }
    }

    private fun backMove() {
        view?.let { it1 ->
            Navigation.findNavController(it1)
                .navigate(R.id.action_CSFragment_to_CSCenterFragment)
        }
    }

    override fun backStack() {
        view?.let { it1 ->
            Navigation.findNavController(it1).popBackStack()
        }

    }


}










