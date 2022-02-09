package com.example.YUmarket.data.network.home

import com.example.YUmarket.data.response.common.BaseResponse
import com.example.YUmarket.data.response.common.ErrorResponse
import com.example.YUmarket.data.response.home.homeItem.HomeItemDetailResponseDto
import com.example.YUmarket.data.url.Url
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * HomeItem에 대한 Api Service를 제공하는 interface
 * @author Doyeop Kim (main)
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/02/07
 */
interface HomeItemApiService {

    // category와 page별로 HomeItem들을 긁어오는 메소드
    @GET(Url.HOME_ITEM_DETAIL_LIST)
    suspend fun searchDetailByPageAndCategory(
        @Query("page") page: Int,
        @Query("category") category: String
    ): Response<BaseResponse<List<HomeItemDetailResponseDto>>>

    // searchDetailByPageAndCategory에서 에러가 발생시 호출이 되는 메소드
    @GET(Url.HOME_ITEM_DETAIL_LIST)
    suspend fun failSearchDetail(
        @Query("page") page: Int,
        @Query("category") category: String
    ): Response<ErrorResponse>
}