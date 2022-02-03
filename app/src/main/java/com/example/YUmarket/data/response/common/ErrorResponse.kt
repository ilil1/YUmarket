package com.example.YUmarket.data.response.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Spring server에서 날아오는 error의 response 형식
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
data class ErrorResponse(

    @SerializedName("message")
    @Expose
    val message: String,

    @SerializedName("status")
    @Expose
    val status: Int,

    @SerializedName("error_list")
    @Expose
    val errorList: List<FieldError>?,

    @SerializedName("code")
    @Expose
    val code: String
)
