package com.example.YUmarket.screen.myinfo.customerservice

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */


import androidx.navigation.Navigation
import com.example.YUmarket.R
import com.example.YUmarket.databinding.FragmentCsBinding
import com.example.YUmarket.screen.base.BaseFragment
import com.example.YUmarket.screen.myinfo.customerservice.list.CSCategory
import com.example.YUmarket.screen.myinfo.customerservice.list.CSListFragment
import com.example.YUmarket.widget.adapter.HomeListFragmentPagerAdapter

class CSFragment : BaseFragment<FragmentCsBinding>() {

    private lateinit var viewAdapter: HomeListFragmentPagerAdapter


    override fun getViewBinding(): FragmentCsBinding =
        FragmentCsBinding.inflate(layoutInflater)

    override fun observeData() {
    }

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






