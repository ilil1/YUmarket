package com.example.YUmarket.di

import com.example.YUmarket.data.repository.basket.BasketRepository
import com.example.YUmarket.data.repository.basket.DefaultBasketRepository
import com.example.YUmarket.data.repository.like.DefaultLikeItemRepository
import com.example.YUmarket.data.repository.like.DefaultLikeMarketRepository
import com.example.YUmarket.data.repository.like.LikeListRepository
import com.example.YUmarket.data.repository.map.DefaultMapApiRepository
import com.example.YUmarket.data.repository.map.DefaultMapRepository
import com.example.YUmarket.data.repository.map.MapApiRepository
import com.example.YUmarket.data.repository.map.MapRepository
import com.example.YUmarket.model.like.LikeItemModel
import com.example.YUmarket.model.like.LikeMarketModel
import com.example.YUmarket.data.repository.myinfo.CSRepository
import com.example.YUmarket.data.repository.myinfo.DefaultCSRepository
import com.example.YUmarket.data.repository.restaurant.DefaultHomeRepository
import com.example.YUmarket.data.repository.restaurant.HomeRepository
import com.example.YUmarket.data.repository.suggest.DefaultSuggestRepository
import com.example.YUmarket.data.repository.suggest.SuggestRepository
import com.example.YUmarket.model.homelist.category.HomeListCategory
import com.example.YUmarket.model.like.LikeCategory
import com.example.YUmarket.screen.MainViewModel
import com.example.YUmarket.screen.home.homelist.HomeListViewModel
import com.example.YUmarket.screen.home.homemain.HomeMainViewModel
import com.example.YUmarket.screen.like.LikeListViewModel
import com.example.YUmarket.screen.map.MapViewModel
import com.example.YUmarket.screen.myinfo.customerservice.list.CSCategory
import com.example.YUmarket.screen.myinfo.customerservice.list.CSListViewModel
import com.example.YUmarket.util.provider.DefaultResourcesProvider
import com.example.YUmarket.util.provider.ResoucesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {


    factory { (homeListCategory: HomeListCategory) ->
        HomeListViewModel(homeListCategory, get())
    }
    /*  CSViewModel 추가  의존성 주입   factory추가
    *   csCategory factory                     */



    factory { (csCategory: CSCategory) ->
        CSListViewModel(csCategory,get())
    }

    viewModel(named(LikeCategory.MARKET)) {
        LikeListViewModel<LikeMarketModel>(
            get(
                qualifier = named("likeMarketRepository")
            )
        )
    }

    viewModel(named(LikeCategory.ITEM)) {
        LikeListViewModel<LikeItemModel>(
            get(
                qualifier = named("likeItemRepository")
            )
        )
    }

    viewModel {HomeMainViewModel(get(),get())}
    viewModel { MainViewModel(get(),get()) }
    viewModel { MapViewModel(get()) }




    single<HomeRepository> { DefaultHomeRepository() }
    single<SuggestRepository> {DefaultSuggestRepository()}
    // mockList 의존성 주입
    single<CSRepository>{ DefaultCSRepository(get()) }
    single<ResoucesProvider>{ DefaultResourcesProvider(androidContext())}

    single { buildOkHttpClient() }
    single { provideGsonConverterFactory() }

    single(named("map")) { provideMapRetrofit(get(), get()) }
    single { provideMapApiService(get(qualifier = named("map"))) }

    single<MapApiRepository> { DefaultMapApiRepository(get(), get()) }
    single<MapRepository> { DefaultMapRepository() }

    single { provideDB(androidContext()) }
    single { provideBasketDao(get()) }
    single { provideLikeItemDao(get()) }
    single { provideLikeMarketDao(get()) }

    single { Dispatchers.IO }
    single { Dispatchers.Main }

    single<BasketRepository> { DefaultBasketRepository(get(), get()) }

    single<LikeListRepository<LikeMarketModel>>(named("likeMarketRepository")) {
        DefaultLikeMarketRepository(get(), get())
    }

    single<LikeListRepository<LikeItemModel>>(named("likeItemRepository")) {
        DefaultLikeItemRepository(get(), get())
    }



}