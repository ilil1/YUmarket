package com.example.myapplication23.widget.adapter.viewholder.cs


import com.example.myapplication23.databinding.ViewholderCsItemBinding
import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.widget.adapter.listener.AdapterListener
import com.example.myapplication23.widget.adapter.listener.customerservice.CSModelListener
import com.example.myapplication23.widget.adapter.viewholder.ModelViewHolderService

/**
 * @주 허희태
 * @부 김건우 정남진 김도엽 배은호
 * @since
 * @throws
 * @description
 */

class CSViewHolder(
    private val binding: ViewholderCsItemBinding,
    viewModel: BaseViewModel,

) : ModelViewHolderService<CSModel>(binding,viewModel) {

    override fun reset() = Unit

    override fun bindData(listModel: CSModel) {
        super.bindData(listModel)

        with(binding){
            questionText.text= listModel.csTitle.toString()
            author.text = listModel.csAuthor.toString()

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

