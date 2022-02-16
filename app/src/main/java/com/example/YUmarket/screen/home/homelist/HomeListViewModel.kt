package com.example.YUmarket.screen.home.homelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.YUmarket.data.repository.restaurant.HomeRepository
import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.model.homelist.TownMarketModel
import com.example.YUmarket.model.homelist.category.HomeListCategory
import com.example.YUmarket.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * HomeListFragment view에 대한 viewModel class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 */
class HomeListViewModel(
    private val homeListCategory: HomeListCategory,
    private val homeRepository: HomeRepository
) : BaseViewModel() {

    val homeListLiveData = when(homeListCategory) {
        HomeListCategory.TOWN_MARKET -> MutableLiveData<List<TownMarketModel>>()
        else -> MutableLiveData<List<HomeItemModel>>()
    }

    override fun fetchData(): Job = viewModelScope.launch {
        homeListLiveData.value = when(homeListCategory) {
            HomeListCategory.TOWN_MARKET -> homeRepository.getMarketListByPage(0)
            HomeListCategory.MART -> homeRepository.getItemListByPageAndCategory(0, HomeListCategory.MART)
            HomeListCategory.FOOD -> homeRepository.getItemListByPageAndCategory(0, HomeListCategory.FOOD)
            HomeListCategory.FASHION -> homeRepository.getItemListByPageAndCategory(0, HomeListCategory.FASHION)
            HomeListCategory.ACCESSORY -> homeRepository.getItemListByPageAndCategory(0, HomeListCategory.ACCESSORY)
            HomeListCategory.SERVICE -> homeRepository.getItemListByPageAndCategory(0, HomeListCategory.SERVICE)
            HomeListCategory.ETC -> homeRepository.getItemListByPageAndCategory(0, HomeListCategory.ETC)
        }
    }
}