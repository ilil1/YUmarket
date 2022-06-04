package com.example.YUmarket.screen

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.UiThread
import androidx.core.view.get
import androidx.core.view.isGone
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.data.entity.location.MapSearchInfoEntity
import com.example.YUmarket.databinding.ActivityMainBinding
import com.example.YUmarket.screen.base.BaseActivity
import com.example.YUmarket.screen.map.MapLocationSetting.MapLocationSettingActivity.Companion.MY_LOCATION_KEY
import com.example.YUmarket.screen.myLocation.MyLocationActivity
import com.google.android.gms.maps.SupportMapFragment
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import org.koin.android.viewmodel.ext.android.viewModel

import com.example.YUmarket.R
import com.example.YUmarket.databinding.FragmentMapBinding
import com.google.android.gms.maps.MapFragment


class MainActivity
    : BaseActivity<ActivityMainBinding>() {

    private lateinit var curLoc :Location

    companion object {
        val locationPermissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

    }

    // Navigation에 사용할 Controller
    private val navController by lazy {
        val hostContainer =
            supportFragmentManager
                .findFragmentById(R.id.fragmentContainer)
                    as NavHost

        hostContainer.navController
    }

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val responsePermissions = permissions.entries.filter {
                it.key in locationPermissions
            }

            if (responsePermissions.filter { it.value == true }.size == locationPermissions.size) {
                setLocationListener()
            } else {
                Toast.makeText(this, "no", Toast.LENGTH_SHORT).show()
            }
        }

    private val changeLocationLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { results ->
            results.data?.getParcelableExtra<MapSearchInfoEntity>(MY_LOCATION_KEY)
                ?.let { myLocationInfo ->
                    viewModel.getReverseGeoInformation(myLocationInfo.locationLatLng)
                }
        }

    private lateinit var locationManager: LocationManager
    private lateinit var myLocationListener: MyLocationListener

    private val viewModel by viewModel<MainViewModel>()


    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


    override fun observeData() = with(binding) {
        viewModel.locationData.observe(this@MainActivity) {
            when (it) {
                is MainState.Uninitialized -> {
                    getMyLocation()
                }

                is MainState.Loading -> {

                }

                is MainState.Success -> {
                    locationLoading.isGone = true
                    locationTitleTextView.text = it.mapSearchInfoEntity.fullAddress
                    viewModel.setDestinationLocation(it.mapSearchInfoEntity.locationLatLng)

                }

                is MainState.Error -> {
                    locationTitleTextView.text = getString(it.errorMessage)
                }
            }
        }
    }

    @SuppressLint("ResourceType")
    override fun initViews() = with(binding) {
       // var m = FragmentMapBinding.inflate(layoutInflater).mapView
       // FragmentMapBinding.inflate(layoutInflater).mapView.getMapAsync(this@MainActivity)


      //  var m = supportFragmentManager.findFragmentById(R.id.fragment_map) as com.naver.maps.map.MapFragment?
       // m?.getMapAsync(this@MainActivity)
/*
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, MapFragment(), "MapFragment").commitAllowingStateLoss()

        var a = fragmentManager.findFragmentByTag("MapFragment") as MapFragment?
        var b =a?.mapView
        b?.getMapAsync(this@MainActivity)

 */

        // 22.01.19 BottomNavigationView의 동작을 Controller를 이용하여 설정
        // by 정남진
        bottomNav.setupWithNavController(navController)
        locationTitleTextView.setOnClickListener {
            viewModel.getMapSearchInfo()?.let { mapInfo ->
                changeLocationLauncher.launch(
                    MyLocationActivity.newIntent(
                        this@MainActivity, mapInfo
                    )
                )
            }
            Toast.makeText(this@MainActivity, "ㄱㄷ", Toast.LENGTH_SHORT).show()
        }
    }


    private fun getMyLocation() {
        if (::locationManager.isInitialized.not()) {
            locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        }
        val isGpsEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (isGpsEnable) {
            permissionLauncher.launch(locationPermissions)
        }
    }

    @Suppress("MissingPermission")
    private fun setLocationListener() {
        val minTime: Long = 1500
        val minDistance = 100f

        if (::myLocationListener.isInitialized.not()) {
            myLocationListener = MyLocationListener()
        }

        with(locationManager) {
            requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime, minDistance, myLocationListener
            )

            requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                minTime, minDistance, myLocationListener
            )
        }
    }

    inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            curLoc = location
            viewModel.setCurrentLocation(curLoc)
//            binding.locationTitleTextView.text = "${location.latitude}, ${location.longitude}"
            viewModel.getReverseGeoInformation(
                LocationLatLngEntity(
                    latitude = location.latitude,
                    longitude = location.longitude
                )
            )

            removeLocationListener()
        }

        private fun removeLocationListener() {
            if (::locationManager.isInitialized && ::myLocationListener.isInitialized) {
                locationManager.removeUpdates(myLocationListener)
            }
        }
    }



}