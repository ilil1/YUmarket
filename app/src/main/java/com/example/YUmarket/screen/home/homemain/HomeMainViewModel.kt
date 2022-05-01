package com.example.YUmarket.screen.home.homemain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.YUmarket.data.repository.restaurant.HomeRepository
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.model.homelist.category.HomeListCategory
import com.example.YUmarket.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class HomeMainViewModel(
    private val homeRepository: HomeRepository
    // TODO 22.01.18 add item repository
) : BaseViewModel() {

    private val _marketData = MutableLiveData<HomeMainState>(HomeMainState.Uninitialized)
    val marketData: LiveData<HomeMainState> = _marketData

    private val _itemData = MutableLiveData<HomeMainState>(HomeMainState.Uninitialized)
    val itemData: LiveData<HomeMainState> = _itemData

    private lateinit var allNewSaleItemsList: List<HomeItemModel>

    override fun fetchData(): Job = viewModelScope.launch {
        // 더 이상 fetchData가 initState에서 실행되지 않고 위치 정보를 불러온 뒤에
        // 실행 되므로 위치 정보를 불러왔는지 확인할 필요가 없음
        fetchMarketData()
        fetchItemData()
    }

    private suspend fun fetchMarketData() {
        // 22.01.19 성공적으로 불러온 뒤에는 reloadData 이외에 Data는 계속 불러오는 것을 방지
        // by 정남진
        if (marketData.value !is HomeMainState.Success<*>) {
            _marketData.value = HomeMainState.Loading

            // sorted by distance
            _marketData.value = HomeMainState.Success(
                // 임시로 CellType을 ViewModel에서 변경
                modelList = homeRepository.getAllMarketList().map {
                    it.copy(type = CellType.HOME_MAIN_MARKET_CELL)
                }.sortedBy { it.distance }
            )
        }
    }

    private suspend fun fetchItemData() {
        if (itemData.value !is HomeMainState.Success<*>) {
            _itemData.value = HomeMainState.Loading

            allNewSaleItemsList = homeRepository.getAllNewSaleItems().map {
                it.copy(type = CellType.HOME_MAIN_ITEM_CELL)
            }
            _itemData.value = HomeMainState.ListLoaded
        }
    }

    fun reloadData(): Job {
        _marketData.value = HomeMainState.Loading
        _itemData.value = HomeMainState.Loading
        return fetchData()
    }

    fun setItemFilter(category: HomeListCategory) {
        if (::allNewSaleItemsList.isInitialized) {
            _itemData.value = HomeMainState.Success(
                // 임시로 CellType을 ViewModel에서 변경
                modelList = allNewSaleItemsList.filter {
                    it.homeListCategory == category
                }
            )
        }
    }
}