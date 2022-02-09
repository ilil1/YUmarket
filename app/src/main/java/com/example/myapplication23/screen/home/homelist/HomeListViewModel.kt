package com.example.myapplication23.screen.home.homelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication23.data.repository.restaurant.HomeRepository
import com.example.myapplication23.model.homelist.HomeItemModel

import com.example.myapplication23.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeListViewModel(
    private val homeCategory: HomeCategory,
    private val homeRepository: HomeRepository
) : BaseViewModel() {
    val homeListData = MutableLiveData<List<HomeItemModel>>()

    override fun fetchData(): Job = viewModelScope.launch {
        // TODO stub
        homeListData.value = homeRepository.getList(homeCategory)
    }
}