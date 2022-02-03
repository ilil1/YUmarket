package com.example.YUmarket.data.response.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

/**
 * Spring server에서 날아오는 response의 추상 형태
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
data class BaseResponse<T> (
    @SerializedName("transaction_time")
    @Expose
    private val transactionTime: LocalDateTime,

    @SerializedName("url")
    @Expose
    private val requestUrl: String,

    @SerializedName("data")
    @Expose
    val data: T?,

    @SerializedName("description")
    @Expose
    private val description : String?,

    @SerializedName("pagination")
    @Expose
    private val pagination: Pagination?
)
