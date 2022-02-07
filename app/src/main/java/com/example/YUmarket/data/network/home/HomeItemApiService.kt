package com.example.YUmarket.data.network.home

import com.example.YUmarket.data.response.home.homeItem.HomeItemDetailResponseDto
import com.example.YUmarket.data.url.Url
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * HomeItem에 대한 Api Service를 제공하는 interface
 * @author Doyeop Kim (main)
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/02/07
 */
interface HomeItemApiService {

    // category와 page별로 HomeItem들을 긁어오는 메소드
    @GET(Url.HOME_ITEM_DETAIL_LIST)
    suspend fun searchByPageAndCategory(
        @Path("page") page: Int,
        @Path("category") category: String
    ): List<HomeItemDetailResponseDto>
}