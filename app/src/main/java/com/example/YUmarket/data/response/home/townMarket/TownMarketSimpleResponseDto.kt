package com.example.YUmarket.data.response.home.townMarket

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * TownMarket에 대한 간략한 응답을 담당하는 dto class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/02/07
 */
data class TownMarketSimpleResponseDto(
    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("latitude")
    @Expose
    val latitude: Double,

    @SerializedName("longitude")
    @Expose
    val longitude: Double
)