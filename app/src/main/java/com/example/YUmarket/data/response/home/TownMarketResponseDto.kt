package com.example.YUmarket.data.response.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Spring server에서 날아오는 TownMarket Response
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
data class TownMarketResponseDto(
    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("is_open")
    @Expose
    val isOpen: Boolean,

    @SerializedName("open_time")
    @Expose
    val openTime: String?,

    @SerializedName("close_time")
    @Expose
    val closeTime: String?,

    @SerializedName("address")
    @Expose
    val address: String?,

    @SerializedName("latitude")
    @Expose
    val latitude: Double,

    @SerializedName("longitude")
    @Expose
    val longitude: Double,

    @SerializedName("market_image_url")
    @Expose
    val marketImageUrl: String?,

    @SerializedName("item_quantity")
    @Expose
    val itemQuantity: Int,

    @SerializedName("like_quantity")
    @Expose
    val likeQuantity: Int,

    @SerializedName("review_quantity")
    @Expose
    val reviewQuantity: Int
)