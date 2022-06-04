package com.example.YUmarket.screen

import android.graphics.Color
import android.location.Location
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.YUmarket.R
import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.data.entity.location.MapSearchInfoEntity
import com.example.YUmarket.data.repository.map.MapApiRepository
import com.example.YUmarket.data.repository.map.MapRepository
import com.example.YUmarket.screen.base.BaseViewModel
import com.example.YUmarket.screen.map.MapState
import com.example.YUmarket.util.provider.ResourcesProvider
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.util.MarkerIcons
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(
    private val mapApiRepository: MapApiRepository,
    private val resourcesProvider: ResourcesProvider,
    private val mapRepository: MapRepository
) : BaseViewModel() {

    private var map : NaverMap? =null

    private val _locationData = MutableLiveData<MainState>(MainState.Uninitialized)
    val locationData: LiveData<MainState> = _locationData

    lateinit var destLocation: LocationLatLngEntity
    lateinit var curLocation: Location
    private lateinit var markers: List<Marker>

    private var destMarker: Marker = Marker(
        MarkerIcons.BLACK
    ).apply {
        zIndex = 111
        iconTintColor = Color.parseColor("#FA295B")
        width = 100
        height = 125
    }
        /**
         * destMarker를 가져올 때마다 위치를 destLocation으로 설정
         */
        get() = field.apply {
            position = LatLng(
                destLocation.latitude,
                destLocation.longitude
            )
        }

    fun setCurrentLocation(loc : Location) {
        curLocation = loc
    }

    fun getCurrentLocation() : Location{
        return curLocation
    }

    fun setDestinationLocation(loc : LocationLatLngEntity) {
        destLocation = loc
    }

    fun getDestinationMarker() : Marker {
        return destMarker
    }

    fun setDestinationMarker(dest : Marker) {
        destMarker = dest
    }

    private val _data = MutableLiveData<MapState>(MapState.Uninitialized)
    val data: LiveData<MapState> = _data

    override fun fetchData(): Job = viewModelScope.launch {
        _data.value = MapState.Loading
        _data.value = MapState.Success(
            markets = mapRepository.getMarkets()
        )
    }

    fun getMap() : NaverMap? {
        return map
    }

    fun setMap(m : NaverMap) {
        map = m
    }

    fun setMarkers(list : List<Marker>){
        markers = list
    }

    fun getMarkers() : List<Marker> {
        return markers
    }

    @Suppress("CAST_NEVER_SUCCEEDS")
    fun getMapSearchInfo(): MapSearchInfoEntity? {
        when (locationData.value) {
            is MainState.Success -> {
                return (locationData.value as MainState.Success).mapSearchInfoEntity
            }
        }
        return null
    }

    fun getReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ) = viewModelScope.launch {

        val currentLocation = locationLatLngEntity

        val addressInfo = mapApiRepository.getReverseGeoInformation(locationLatLngEntity)

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

    private fun deleteMarkers() {
        for (marker in markers) {
            marker.map = null
        }
    }

    public fun updateLocation(location: LocationLatLngEntity) {
        // 위치 업데이트 될 때마다 목적지 마커 초기화
        destLocation = location

        deleteMarkers()

        map?.cameraPosition = CameraPosition(
            LatLng(
                destLocation.latitude,
                destLocation.longitude
            ), 15.0
        )

        destMarker.map = map
    }
}