package com.example.myapplication23.screen.myinfo.customerservice.list


import android.icu.util.ULocale
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication23.data.repository.myinfo.CSRepository
import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.base.BaseViewModel
import com.example.myapplication23.widget.adapter.listener.customerservice.CSModelListener
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.ext.getOrCreateScope
import java.util.*

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class CSListViewModel (
    private val csCategory: CSCategory,
    private val csRepository: CSRepository
    ): BaseViewModel() {
    val csListData = MutableLiveData<List<CSModel>>()

   override fun fetchData(): Job = viewModelScope.launch {
       csListData.value = when(csCategory){
        CSCategory.TOTAL-> csRepository.findCsByCategory(CSCategory.TOTAL)
        CSCategory.ORDER-> csRepository.findCsByCategory(CSCategory.ORDER)
        CSCategory.REVIEW -> csRepository.findCsByCategory(CSCategory.REVIEW)
        CSCategory.LOGIN -> csRepository.findCsByCategory(CSCategory.LOGIN)
        CSCategory.USE -> csRepository.findCsByCategory(CSCategory.USE)
        CSCategory.ETC -> csRepository.findCsByCategory(CSCategory.ETC)
         }
    }

    }
