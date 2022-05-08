package com.example.YUmarket.screen.map

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.data.repository.map.MapRepository
import com.example.YUmarket.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MapViewModel(
    private val mapRepository: MapRepository
) : BaseViewModel() {
    private val _data = MutableLiveData<MapState>(MapState.Uninitialized)
    val data: LiveData<MapState> = _data

    lateinit var destLocation: LocationLatLngEntity
    lateinit var curLocation: Location

    override fun fetchData(): Job = viewModelScope.launch {
        _data.value = MapState.Loading
        _data.value = MapState.Success(
            markets = mapRepository.getMarkets()
        )
    }
}