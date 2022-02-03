package com.example.YUmarket.widget.adapter.viewholder.home

import com.example.YUmarket.R
import com.example.YUmarket.databinding.ViewholderTownMarketBinding
import com.example.YUmarket.extensions.clear
import com.example.YUmarket.extensions.load
import com.example.YUmarket.model.homelist.TownMarketModel
import com.example.YUmarket.screen.base.BaseViewModel
import com.example.YUmarket.util.provider.ResourcesProvider
import com.example.YUmarket.widget.adapter.listener.AdapterListener
import com.example.YUmarket.widget.adapter.listener.home.TownMarketListener
import com.example.YUmarket.widget.adapter.viewholder.ModelViewHolder

/**
 * TownMarket에 대한 RecyclerView의 ViewHolder class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 */
class TownMarketViewHolder(
    private val binding: ViewholderTownMarketBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
) : ModelViewHolder<TownMarketModel>(binding, viewModel, resourcesProvider) {

    override fun reset() = with(binding) {
        marketImageView.clear()
    }

    override fun bindData(model: TownMarketModel) {
        super.bindData(model)

        with(binding) {
            // TODO 실제 데이터를 받아오는 경우 데이터가 잘 반영이 되도록 수정
            model.marketImageUrl?.let {
                marketImageView.load(it, 16f)
            }
            marketNameText.text = model.marketName // data
            distanceTextView.text = model.distance.toString() + "km" // data
            stockTextView.text = model.itemQuantity.toString() + "개 상품 판매중" // data
            likeCountTextView.text = model.likeQuantity.toString() // data
            reviewCountTextView.text = model.reviewQuantity.toString() // data

            likeTextView.text = resourcesProvider.getString(R.string.like)
            reviewTextView.text = resourcesProvider.getString(R.string.review)

            when (model.isMarketOpen) {
                true -> marketOpenStatusView.apply {
                    text = resourcesProvider.getString(R.string.market_open)
                    background =
                        resourcesProvider.getDrawable(R.drawable.viewholder_town_market_open_shape)
                }

                false -> marketOpenStatusView.apply {
                    text = resourcesProvider.getString(R.string.market_closed)
                    background =
                        resourcesProvider.getDrawable(R.drawable.viewholder_town_market_closed_shape)
                }
            }

        }
    }

    override fun bindViews(model: TownMarketModel, listener: AdapterListener) {
        if (listener is TownMarketListener) {
            with(binding) {
                root.setOnClickListener {
                    listener.onClickItem(model)
                }
            }
        }
    }
}