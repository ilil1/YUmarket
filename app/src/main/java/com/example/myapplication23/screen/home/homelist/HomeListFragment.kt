package com.example.myapplication23.screen.home.homelist

import com.example.myapplication23.util.provider.ResoucesProvider
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication23.databinding.FragmentHomeListBinding
import com.example.myapplication23.model.Model
import com.example.myapplication23.model.homelist.HomeItemModel
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.widget.adapter.ModelRecyclerAdapter
import com.example.myapplication23.widget.adapter.listener.home.HomeListListener
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
}