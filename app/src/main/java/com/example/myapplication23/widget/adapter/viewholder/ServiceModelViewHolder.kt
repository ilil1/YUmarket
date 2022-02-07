package com.example.myapplication23.widget.adapter.viewholder

import android.content.res.loader.ResourcesProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication23.databinding.ViewholderCsItemBinding

import com.example.myapplication23.model.Model
//import com.example.myapplication23.model.customerservicelist.CSItemModel
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.widget.adapter.listener.AdapterListener

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */



abstract class ServiceModelViewHolder <M :Model>(
    binding: ViewholderCsItemBinding,
    protected val viewModel: BaseViewModel,
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bindData(model: M) {
        reset()
    }

    abstract fun bindViews(model: M, listener: AdapterListener)
}