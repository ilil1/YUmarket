package com.example.YUmarket.model.homelist.category

import androidx.annotation.StringRes
import com.example.YUmarket.R
import com.google.gson.annotations.SerializedName


/**
 * HomeItem들의 대분류를 정의한 enum class
 * @author Doyeop Kim (main)
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 * @param categoryNameId View에서 보여지는 카테고리의 이름
 * @param categoryTypeId 검색 쿼리에 활용이 되는 카테고리의 이름
 */
enum class HomeListCategory(
    @StringRes val categoryNameId: Int,
    @StringRes val categoryTypeId: Int
) {
    @SerializedName("TOWN_MARKET")
    TOWN_MARKET(R.string.all, R.string.all_type),

    @SerializedName("FOOD_BEVERAGE")
    FOOD(R.string.food, R.string.food_type),

    @SerializedName("MART")
    MART(R.string.mart, R.string.mart_type),

    @SerializedName("SERVICE")
    SERVICE(R.string.service, R.string.service_type),

    @SerializedName("FASHION")
    FASHION(R.string.fashion, R.string.fashion_type),

    @SerializedName("ACCESSORY")
    ACCESSORY(R.string.accessory, R.string.accessory_type),

    @SerializedName("ETC")
    ETC(R.string.etc, R.string.etc_type)
}