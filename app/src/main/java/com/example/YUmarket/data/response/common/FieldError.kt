package com.example.YUmarket.data.response.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Spring server에서 날아오는 error 중 field에 대한 error를 담는 데이터 클래스
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
data class FieldError(
    @SerializedName("field")
    @Expose
    private val field: String,

    @SerializedName("value")
    @Expose
    private val value: String,

    @SerializedName("reason")
    @Expose
    private val reason: String
)
