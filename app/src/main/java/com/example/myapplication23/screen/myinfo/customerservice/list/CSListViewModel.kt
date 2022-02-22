package com.example.myapplication23.screen.myinfo.customerservice.list


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication23.data.repository.myinfo.CSRepository
import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class CSListViewModel (
    private val csRepository: CSRepository
): BaseViewModel() {
    private val _csListData = MutableLiveData<List<CSModel>>()
    val csListData :  LiveData<List<CSModel>>
        get() = _csListData


    override fun fetchData(): Job = viewModelScope.launch {
        _csListData.value =
            csRepository.findCsByCategory(CSCategory.TOTAL)
    }
}