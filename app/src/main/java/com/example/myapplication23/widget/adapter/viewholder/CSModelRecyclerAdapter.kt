package com.example.myapplication23.widget.adapter.viewholder

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory
import com.example.myapplication23.util.mapper.ViewHolderMapperCS
import com.example.myapplication23.widget.adapter.listener.AdapterListener

/**
 * @주 허희태
 * @부 김건우 정남진 김도엽 배은호
 * @since
 * @throws
 * @description
 */



class CSModelRecyclerAdapter<M: CSModel,VM:BaseViewModel>(
    private var modelList: List<CSModel>,
    private val viewModel: VM,
    private val adapterListener: AdapterListener
): ListAdapter<CSModel,ModelViewHolderService<M>>(CSModel.DIFF_CALLBACK){

    override fun getItemViewType(position: Int): Int = modelList[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolderService<M> =
        ViewHolderMapperCS.map(parent,CSCategory.values()[viewType],viewModel)


    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: ModelViewHolderService<M>, position: Int) {
        holder.bindData(modelList[position] as M)
        holder.bindViews(modelList[position] as M, adapterListener)
    }

    override fun submitList(list: List<CSModel>?) {
        list?.let { modelList = it }
        super.submitList(list)
    }




}