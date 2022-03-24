package com.example.YUmarket.di

import com.example.YUmarket.data.repository.basket.BasketRepository
import com.example.YUmarket.data.repository.basket.DefaultBasketRepository
import com.example.YUmarket.data.repository.map.DefaultMapRepository
import com.example.YUmarket.data.repository.map.MapRepository
import com.example.YUmarket.data.repository.home.DefaultHomeRepository
import com.example.YUmarket.data.repository.home.HomeRepository
import com.example.YUmarket.data.repository.like.DefaultLikeItemRepository
import com.example.YUmarket.data.repository.like.DefaultLikeMarketRepository
import com.example.YUmarket.data.repository.like.LikeListRepository
import com.example.YUmarket.model.homelist.category.HomeListCategory
import com.example.YUmarket.model.like.LikeCategory
import com.example.YUmarket.model.like.LikeItemModel
import com.example.YUmarket.model.like.LikeMarketModel
import com.example.YUmarket.screen.MainViewModel
import com.example.YUmarket.screen.home.homelist.HomeListViewModel
import com.example.YUmarket.screen.home.homemain.HomeMainViewModel
import com.example.YUmarket.screen.like.LikeListViewModel
import com.example.YUmarket.screen.orderlist.OrderListViewModel
import com.example.YUmarket.util.provider.DefaultResourcesProvider
import com.example.YUmarket.util.provider.ResourcesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    factory { (homeListCategory: HomeListCategory) ->
        HomeListViewModel(homeListCategory, get())
    }

    viewModel { MainViewModel(get(), get()) }
    viewModel { OrderListViewModel() }

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

    single<HomeRepository> { DefaultHomeRepository() }

    single { buildOkHttpClient() }
    single { provideGsonConverterFactory() }

    single(named("map")) { provideMapRetrofit(get(), get()) }
    single { provideMapApiService(get(qualifier = named("map"))) }

    single<MapRepository> { DefaultMapRepository(get(), get()) }

    single<ResourcesProvider> { DefaultResourcesProvider(androidContext()) }

    single { Dispatchers.IO }
    single { Dispatchers.Main }

    viewModel { HomeMainViewModel(get()) }

    single { provideDB(androidContext()) }
    single { provideBasketDao(get()) }
    single { provideLikeItemDao(get()) }
    single { provideLikeMarketDao(get()) }

    single<BasketRepository> { DefaultBasketRepository(get(), get()) }

    single<LikeListRepository<LikeMarketModel>>(named("likeMarketRepository")) {
        DefaultLikeMarketRepository(get(), get())
    }

    single<LikeListRepository<LikeItemModel>>(named("likeItemRepository")) {
        DefaultLikeItemRepository(get(), get())
    }
}