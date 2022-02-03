package com.example.YUmarket.data.response.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

/**
 * Spring server에서 날아오는 MarketReview Response
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
data class MarketReviewResponseDto(

    @SerializedName("id")
    @Expose
    private val id: Long,

    @SerializedName("grade")
    @Expose
    private val grade: Double,

    @SerializedName("content")
    @Expose
    private val content: String,

    @SerializedName("created_at")
    @Expose
    private val createdAt: LocalDateTime,

    @SerializedName("updated_at")
    @Expose
    private val updatedAt: LocalDateTime?,

    @SerializedName("town_market_id")
    @Expose
    private val townMarketId: Long,

    @SerializedName("user_id")
    @Expose
    private val userId: Long
)