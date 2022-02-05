package com.example.myapplication23.widget.adapter.viewholder.cs


import android.content.Intent
import com.example.myapplication23.databinding.ViewholderCsItemBinding
import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.widget.adapter.listener.AdapterListener
import com.example.myapplication23.widget.adapter.listener.customerservice.CSModelListener
import com.example.myapplication23.widget.adapter.viewholder.ServiceModelViewHolder

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class CSViewHolder(
    private val binding: ViewholderCsItemBinding,
    viewModel: BaseViewModel
) : ServiceModelViewHolder<CSModel>(binding,viewModel) {


    override fun reset() = Unit

    override fun bindData(listModel: CSModel) {
        super.bindData(listModel)

        with(binding) {
            questionText.text = listModel.csTitle
            author.text = listModel.csAuthor

        }
    }


    override fun bindViews(listmodel: CSModel, listener: AdapterListener) = with(binding){
        if (listener is CSModelListener) {
            binding.root.setOnClickListener {
                listener.onClickItem(listmodel)
            }
        }
    }


}

