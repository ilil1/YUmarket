package com.example.myapplication23.widget.adapter.viewholder

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.widget.adapter.viewholder.cs.CSViewHolderAdapter
import com.example.myapplication23.widget.adapter.listener.AdapterListener

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */


class CSModelRecyclerAdapter<M: CSModel,VM:BaseViewModel>(
    private var modelList: List<CSModel>,
    private val viewModel: VM,
    private val adapterListener: AdapterListener
): ListAdapter<CSModel,ServiceModelViewHolder<M>>(CSModel.DIFF_CALLBACK){

    override fun getItemViewType(position: Int): Int = modelList[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceModelViewHolder<M> =
        CSViewHolderAdapter.put(parent,viewModel)



    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holderModelViewHolder: ServiceModelViewHolder<M>, position: Int) {
        holderModelViewHolder.bindData(modelList[position] as M)
        holderModelViewHolder.bindViews(modelList[position] as M, adapterListener)
    }

    override fun submitList(list: List<CSModel>?) {
        list?.let { modelList = it }
        super.submitList(list)
    }




}