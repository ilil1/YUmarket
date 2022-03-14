package com.example.YUmarket.util.mapper

import com.example.YUmarket.util.provider.ResoucesProvider
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.YUmarket.databinding.*
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.Model
import com.example.YUmarket.screen.base.BaseViewModel
import com.example.YUmarket.widget.adapter.viewholder.ModelViewHolder

import com.example.YUmarket.widget.adapter.viewholder.cs.CSViewHolder
import com.example.YUmarket.widget.adapter.viewholder.restaurant.RestaurantViewHolder

object ViewHolderMapper {
    @Suppress("UNCHECKED_CAST")
    fun <M : Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResoucesProvider
    ): ModelViewHolder<M> {

        val inflater = LayoutInflater.from(parent.context)

        return when (type) {
            CellType.HOME_ITEM_CELL -> {
                RestaurantViewHolder(
                    ViewholderRestaurantBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider

                )
            }

            CellType.HOME_TOWN_MARKET_CELL -> {
                RestaurantViewHolder(
                    ViewholderRestaurantBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider

                    )
            }

            CellType.HOME_CELL -> {
                RestaurantViewHolder(
                    ViewholderRestaurantBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider
                )
            }

            CellType.CUSTOMER_SERVICE_CELL -> {
                CSViewHolder(
                    ViewholderCsItemBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider
                    )
            }



        } as ModelViewHolder<M>

    }



}