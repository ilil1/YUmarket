package com.example.myapplication23.widget.adapter.listener.customerservice


import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.widget.adapter.listener.AdapterListener

interface CSModelListener: AdapterListener {
    fun onClickItem(listModel: CSModel)
}
