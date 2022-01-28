package com.example.myapplication23.screen.myinfo.customerservice.list.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication23.data.repository.myinfo.CSRepository
import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CSDetailViewModel(
    private val csRepository: CSRepository
) : BaseViewModel() {
   val csDetailData = MutableLiveData<List<CSModel>>()

    override fun fetchData(): Job = viewModelScope.launch {


    }
}