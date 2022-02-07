package com.example.YUmarket.data.network.home

import com.example.YUmarket.data.response.common.BaseResponse
import com.example.YUmarket.data.response.home.townMarket.TownMarketResponseDto
import com.example.YUmarket.data.url.Url
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * TownMarket에 대한 network 처리를 담당하는 service interface
 * @author Doyeop Kim (main)
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
interface TownMarketApiService {

    // summarized read : TownMarket의 대략적인 정보를 받아오는 메소드 - test x
    @GET(Url.TOWN_MARKET)
    suspend fun read(
        @Path("id") id: Long
    ): Response<BaseResponse<TownMarketResponseDto>>

    // detail read : TownMarket의 자세한 정보를 받아오는 메소드 - test x
    @GET(Url.TOWN_MARKET_DETAIL)
    suspend fun readDetail(
        @Path("id") id: Long
    ) : Response<BaseResponse<TownMarketResponseDto>>

    // read list : TownMarket의 리스트를 뽑아오는 메소드
    @GET(Url.TOWN_MARKET_LIST)
    suspend fun getList(
        @Query("page") page: Int
    ): Response<BaseResponse<List<TownMarketResponseDto>>>
}