package com.example.myapplication23.screen

import com.example.myapplication23.util.provider.ResoucesProvider
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication23.R
import com.example.myapplication23.data.entity.location.LocationLatLngEntity
import com.example.myapplication23.data.entity.location.MapSearchInfoEntity
import com.example.myapplication23.data.repository.map.MapRepository
import com.example.myapplication23.screen.base.BaseViewModel

import kotlinx.coroutines.launch

class MainViewModel(
    private val mapRepository: MapRepository,
    private val resourcesProvider: ResoucesProvider
) : BaseViewModel() {

    //    val mainStateLiveData = MutableLiveData<MainState>(MainState.Uninitialized)

    private val _locationData = MutableLiveData<MainState>(MainState.Uninitialized)
    val locationData: LiveData<MainState> = _locationData

    fun getMapSearchInfo() {
    }

    fun getReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ) = viewModelScope.launch {

        val currentLocation = locationLatLngEntity

        val addressInfo = mapRepository.getReverseGeoInformation(locationLatLngEntity)

        addressInfo?.let { addressInfoResult ->
            _locationData.value = MainState.Success(
                mapSearchInfoEntity = MapSearchInfoEntity(
                    fullAddress = addressInfoResult.fullAddress
                        ?: resourcesProvider.getString(R.string.no_address_info_found),
                    name = addressInfoResult.buildingName
                        ?: resourcesProvider.getString(R.string.no_address_info_found),
                    locationLatLng = currentLocation
                ),
                isLocationSame = false
            )
        } ?: MainState.Error(
            R.string.cannot_load_address_info
        )
    }
}