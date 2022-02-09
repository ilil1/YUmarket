package com.example.YUmarket.screen.base

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.YUmarket.data.exceptions.EntityNotFoundException
import com.example.YUmarket.data.exceptions.ErrorCode
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected var stateBundle: Bundle? = null

    open fun fetchData(): Job = viewModelScope.launch {  }

    open fun storeState(stateBundle: Bundle) {
        this.stateBundle = stateBundle

    }


    // 2022/01/31 coroutineExceptionHandler 추가 by 김도엽
    val errorCodeLiveData = MutableLiveData<ErrorCode>()

    open val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when(throwable) {
            is EntityNotFoundException -> errorCodeLiveData.value = ErrorCode.ENTITY_NOT_FOUND
            else -> errorCodeLiveData.value = ErrorCode.UNDEFINED_ERROR
        }
    }
}