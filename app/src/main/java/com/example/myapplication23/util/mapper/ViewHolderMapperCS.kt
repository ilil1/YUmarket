package com.example.myapplication23.util.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication23.databinding.ViewholderCsItemBinding
import com.example.myapplication23.model.Model
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory
import com.example.myapplication23.widget.adapter.viewholder.ServiceModelViewHolder
import com.example.myapplication23.widget.adapter.viewholder.cs.CSViewHolder

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */


object ViewHolderMapperCS {
    @Suppress("UNCHECKED_CAST")
    fun <M : Model> map(
        parent: ViewGroup,
        category : CSCategory,
        viewModel: BaseViewModel,
    ): ServiceModelViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)

        val viewHolderService = when(category){
            is CSCategory -> CSViewHolder(
                ViewholderCsItemBinding.inflate(inflater),
                viewModel
            )

        }
       return viewHolderService as ServiceModelViewHolder<M>
    }



}