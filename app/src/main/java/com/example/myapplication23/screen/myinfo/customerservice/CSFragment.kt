package com.example.myapplication23.screen.myinfo.customerservice

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */


import androidx.navigation.Navigation
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentCsBinding
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory
import com.example.myapplication23.screen.myinfo.customerservice.list.CSListFragment
import com.example.myapplication23.widget.adapter.HomeListFragmentPagerAdapter

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
            intentMyinfo()
            doubleBackStack()
        }

        binding.editBtn.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_CSFragment_to_emailFragment)
            }


        }
                binding.csback.setOnClickListener {
                    back()
                }
    }

    private fun intentMyinfo(){
        view?.let { it1 ->
            Navigation.findNavController(it1)
                .navigate(R.id.action_CSFragment_to_myInfoFragment)

        }
    }

    private fun doubleBackStack(){
        view?.let{it1 ->
            Navigation.findNavController(it1).popBackStack()
        }
        view?.let{it1 ->
            Navigation.findNavController(it1).popBackStack()
        }
    }

    private fun back() {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_CSFragment_to_CSCenterFragment)
        }
        view?.let{it1 ->
            Navigation.findNavController(it1).popBackStack()
        }
    }


    }



