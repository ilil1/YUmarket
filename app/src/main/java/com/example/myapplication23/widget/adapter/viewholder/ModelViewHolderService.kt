package com.example.myapplication23.widget.adapter.viewholder

import android.content.res.loader.ResourcesProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication23.databinding.ViewholderCsItemBinding

import com.example.myapplication23.model.Model
//import com.example.myapplication23.model.customerservicelist.CSItemModel
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.widget.adapter.listener.AdapterListener

/**
 * @주 허희태
 * @부 김건우 정남진 김도엽 배은호
 * @since
 * @throws
 * @description
 */



abstract class ModelViewHolderService <M :Model>(
    binding: ViewholderCsItemBinding,
    protected val viewModel: BaseViewModel,
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bindData(model: M) {
        reset()
    }

    abstract fun bindViews(model: M, listener: AdapterListener)
}