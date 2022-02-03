package com.example.YUmarket.data.response.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

/**
 * Spring server에서 날아오는 HomeItem Response
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
data class HomeItemResponseDto(

    @SerializedName("id")
    @Expose
    private val id: Long,

    @SerializedName("detail_category")
    @Expose
    private val detailCategory: String,

    @SerializedName("item_image_url")
    @Expose
    private val itemImageUrl: String?,

    @SerializedName("name")
    @Expose
    private val name: String,

    @SerializedName("original_price")
    @Expose
    private val originalPrice: Int,

    @SerializedName("sale_price")
    @Expose
    private val salePrice: Int,

    @SerializedName("stock_quantity")
    @Expose
    private val stockQuantity: Int,

    @SerializedName("created_at")
    @Expose
    private val createdAt: LocalDateTime,

    @SerializedName("sale_updated_at")
    @Expose
    private val saleUpdatedAt: LocalDateTime?,

    @SerializedName("town_market_id")
    @Expose
    private val townMarketId: Long
)
