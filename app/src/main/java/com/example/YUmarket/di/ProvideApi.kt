package com.example.YUmarket.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.YUmarket.BuildConfig
import com.example.YUmarket.data.network.MapApiService
import com.example.YUmarket.data.network.home.HomeItemApiService
import com.example.YUmarket.data.network.home.TownMarketApiService
import com.example.YUmarket.data.url.Url
import com.example.YUmarket.di.gsonAdapter.LocalDateTimeTypeAdapter
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

fun provideMapApiService(retrofit: Retrofit): MapApiService {
    return retrofit.create(MapApiService::class.java)
}

/**
 * TownMarket에 대한 network service를 제공하는 메소드
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
fun provideTownMarketApiService(retrofit: Retrofit): TownMarketApiService = retrofit.create(
    TownMarketApiService::class.java
)

/**
 * HomeItem에 대한 network service를 제공하는 메소드
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/02/07
 */
fun provideHomeItemApiService(retrofit: Retrofit): HomeItemApiService = retrofit.create(
    HomeItemApiService::class.java
)

fun provideMapRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory,
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Url.TMAP_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}

/**
 * YU_Market 자체 서버에 대한 retrofit을 제공하는 메소드
 * @author Doyeop Kim (main)
 * @since 2022/01/28
 */
fun provideYuMarketRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Url.YU_MARKET_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}

@RequiresApi(Build.VERSION_CODES.O)
fun provideGsonConverterFactory(): GsonConverterFactory {
    val gson = GsonBuilder()
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter().nullSafe())
        .create()

    return GsonConverterFactory.create(gson)
}

fun buildOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()

    interceptor.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE

    return OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}