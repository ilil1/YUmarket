package com.example.myapplication23.widget.adapter.viewholder.cs

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication23.databinding.ViewholderCsItemBinding
import com.example.myapplication23.model.Model
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.widget.adapter.viewholder.ServiceModelViewHolder

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */


object CSViewHolderAdapter {
    @Suppress("UNCHECKED_CAST")
    fun <M : Model> put(
        parent: ViewGroup,
        viewModel: BaseViewModel,
    ): ServiceModelViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)

        val viewHolderService =
            CSViewHolder(
                ViewholderCsItemBinding.inflate(inflater),
                viewModel
            )
       return viewHolderService as ServiceModelViewHolder<M>
    }



}