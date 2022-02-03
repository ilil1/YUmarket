package com.example.YUmarket.data.response.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalTime

/**
 * Spring server에서 날아오는 TownMarket Detail Response
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
data class TownMarketDetailResponseDto(
    @SerializedName("id")
    @Expose
    private val id: Long,

    @SerializedName("name")
    @Expose
    private val name: String,

    @SerializedName("is_open")
    @Expose
    private val isOpen: Boolean,

    @SerializedName("open_time")
    @Expose
    private val openTime: LocalTime?,

    @SerializedName("close_time")
    @Expose
    private val closeTime: LocalTime?,

    @SerializedName("address")
    @Expose
    private val address: String?,

    @SerializedName("latitude")
    @Expose
    private val latitude: Double,

    @SerializedName("longitude")
    @Expose
    private val longitude: Double,

    @SerializedName("market_image_url")
    @Expose
    private val marketImageUrl: String?,

    @SerializedName("item_quantity")
    @Expose
    private val itemQuantity: Int,

    @SerializedName("like_quantity")
    @Expose
    private val likeQuantity: Int,

    @SerializedName("review_quantity")
    @Expose
    private val reviewQuantity: Int,

    @SerializedName("item_list")
    @Expose
    private val itemList: List<HomeItemResponseDto>,

    @SerializedName("review_list")
    @Expose
    private val reviewList: List<MarketReviewResponseDto>
)