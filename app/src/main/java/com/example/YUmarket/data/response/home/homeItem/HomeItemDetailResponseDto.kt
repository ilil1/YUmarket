package com.example.YUmarket.data.response.home.homeItem

import com.example.YUmarket.data.response.home.townMarket.TownMarketSimpleResponseDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

/**
 * HomeItem에 대한 상세한 response를 담당하는 클래스
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/02/07
 */
data class HomeItemDetailResponseDto(
    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("category")
    @Expose
    val category: String,

    @SerializedName("detail_category")
    @Expose
    val detailCategory: String,

    @SerializedName("item_image_url")
    @Expose
    val itemImageUrl: String?,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("original_price")
    @Expose
    val originalPrice: Int,

    @SerializedName("sale_price")
    @Expose
    val salePrice: Int,

    @SerializedName("stock_quantity")
    @Expose
    val stockQuantity: Int,

    @SerializedName("created_at")
    @Expose
    val createdAt: LocalDateTime,

    @SerializedName("sale_updated_at")
    @Expose
    val saleUpdatedAt: LocalDateTime?,

    @SerializedName("town_market_id")
    @Expose
    val townMarketId: Long,

    @SerializedName("market_info")
    @Expose
    val marketInfo: TownMarketSimpleResponseDto
)