package com.example.YUmarket.screen.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.example.YUmarket.data.exceptions.ErrorCode
import kotlinx.coroutines.Job

abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    abstract val viewModel: VM
    abstract fun getViewBinding(): VB

    protected val binding by lazy {
        getViewBinding()
    }

    private lateinit var fetchJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initState()
    }

    open fun initState() {
        initViews()
        fetchJob = viewModel.fetchData()
        observeData()
    }

    open fun initViews() = Unit

    abstract fun observeData()

    // 2022/01/31 error observing 추가 by 김도엽
    // TODO 에러 발생 시 예외 처리의 상세화
    open fun observeError() = viewModel.errorCodeLiveData.observe(this) {
        when(it) {
            ErrorCode.ENTITY_NOT_FOUND -> Toast.makeText(this, "Entity is not found", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        if (fetchJob.isActive) {
            fetchJob.cancel()
        }
        super.onDestroy()
    }
}