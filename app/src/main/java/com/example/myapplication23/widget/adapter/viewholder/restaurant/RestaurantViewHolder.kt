package com.example.myapplication23.widget.adapter.viewholder.restaurant

import com.example.myapplication23.util.provider.ResoucesProvider
import com.example.myapplication23.databinding.ViewholderRestaurantBinding
import com.example.myapplication23.model.homelist.HomeItemModel
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.widget.adapter.listener.AdapterListener
import com.example.myapplication23.widget.adapter.listener.home.HomeListListener
import com.example.myapplication23.widget.adapter.viewholder.ModelViewHolder

class RestaurantViewHolder(
    private val binding: ViewholderRestaurantBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResoucesProvider
) : ModelViewHolder<HomeItemModel>(binding, viewModel,resourcesProvider) {
    override fun reset() = Unit

    override fun bindData(listModel: HomeItemModel) {
        super.bindData(listModel)
        binding.restaurantTitle.text = listModel.title
    }

    override fun bindViews(listModel: HomeItemModel, listener: AdapterListener) {
        if (listener is HomeListListener) {
            binding.root.setOnClickListener {
                listener.onClickItem(listModel)
            }
        }
    }
}