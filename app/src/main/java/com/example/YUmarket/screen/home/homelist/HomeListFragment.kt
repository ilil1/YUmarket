package com.example.YUmarket.screen.home.homelist

import com.example.YUmarket.util.provider.ResoucesProvider
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.YUmarket.databinding.FragmentHomeListBinding
import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.screen.base.BaseFragment
import com.example.YUmarket.widget.adapter.ModelRecyclerAdapter
import com.example.YUmarket.widget.adapter.listener.home.HomeListListener
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.android.ext.android.inject

class HomeListFragment : BaseFragment<FragmentHomeListBinding>() {

    override fun getViewBinding(): FragmentHomeListBinding =
        FragmentHomeListBinding.inflate(layoutInflater)

    private val homeCategory: HomeCategory by lazy {
        arguments?.getSerializable(HOME_CATEGORY_KEY) as HomeCategory
    }

    private val viewModel by viewModel<HomeListViewModel> {
        parametersOf(homeCategory)
    }

    private val resourcesProvider by inject<ResoucesProvider>()

    private val adapter by lazy {
        ModelRecyclerAdapter<HomeItemModel, HomeListViewModel>(
            listOf(),
            viewModel,
            resourcesProvider,
            object: HomeListListener {
                override fun onClickItem(Model: HomeItemModel) {
                    // TODO change to detail activity
                    showMessage(Model.toString())
                }
            }
        )
    }

    override fun initViews() = with(binding) {
    restaurantRecyclerView.adapter = adapter
    restaurantRecyclerView.layoutManager = LinearLayoutManager(this@HomeListFragment.context)

        // TODO delete

    }

    private fun showMessage(message: String) =
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()



    override fun observeData() = with(viewModel) {
        homeListData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        const val HOME_CATEGORY_KEY = "HomeCategoryKey"

        fun newInstance(homeCategory: HomeCategory) : HomeListFragment {
            val bundle = Bundle().apply {
                putSerializable(HOME_CATEGORY_KEY, homeCategory)
            }

            return HomeListFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun backStack() {
    }
}