package com.example.YUmarket.data.response.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Spring server에서 날아오는 response의 Pagination을 담는 class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 */
data class Pagination(
    @SerializedName("total_page")
    @Expose
    val totalPage: Int,

    @SerializedName("total_elements")
    @Expose
    val totalElements: Long,

    @SerializedName("current_page")
    @Expose
    val currentPage: Int,

    @SerializedName("current_elements")
    @Expose
    val currentElements: Int
)