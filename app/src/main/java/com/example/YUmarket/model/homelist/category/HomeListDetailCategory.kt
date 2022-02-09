package com.example.YUmarket.model.homelist.category

import androidx.annotation.StringRes
import com.example.YUmarket.R
import com.google.gson.annotations.SerializedName

/**
 * HomeListFragment에 적용되는 세부 카테고리.
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 * @param detailCategoryNameId View에서 보여지는 카테고리의 세부 분류
 * @param detailCategoryTypeId 검색 쿼리에 사용이 될 카테고리의 세부 분류
 * @param homeListCategory 해당 카테고리의 대분류
 */
enum class HomeListDetailCategory(
    @StringRes detailCategoryNameId: Int,
    @StringRes detailCategoryTypeId: Int,
    private val homeListCategory: HomeListCategory
) {
    @SerializedName("TOWN_MARKET_ALL")
    TOWN_MARKET_ALL(R.string.home_detail_all, R.string.home_detail_all_type, HomeListCategory.TOWN_MARKET),

    @SerializedName("FOOD")
    TOWN_MARKET_FOOD(R.string.food, R.string.food_type, HomeListCategory.TOWN_MARKET),

    @SerializedName("MART")
    TOWN_MARKET_MART(R.string.mart, R.string.mart_type, HomeListCategory.TOWN_MARKET),

    @SerializedName("SERVICE")
    TOWN_MARKET_SERVICE(R.string.service, R.string.service_type, HomeListCategory.TOWN_MARKET),

    @SerializedName("FASHION")
    TOWN_MARKET_FASHION(R.string.fashion, R.string.fashion_type, HomeListCategory.TOWN_MARKET),

    @SerializedName("ACCESSORY")
    TOWN_MARKET_ACCESSORY(R.string.accessory, R.string.accessory_type, HomeListCategory.TOWN_MARKET),

    @SerializedName("FOOD_ALL")
    FOOD_ALL(R.string.home_detail_all, R.string.home_detail_all_type, HomeListCategory.FOOD),

    @SerializedName("JOKBAL_BOSSAM")
    JOKBAL_BOSSAM(R.string.home_detail_jokbal_bossam, R.string.home_detail_jokbal_bossam_type, HomeListCategory.FOOD),

    @SerializedName("CUTLET_JAPAN")
    CUTLET_JAPAN_FOOD(R.string.home_detail_cutlet_japan, R.string.home_detail_cutlet_japan_type, HomeListCategory.FOOD),

    @SerializedName("CAFE_BREAD")
    CAFE_BREAD(R.string.home_detail_cafe_bread, R.string.home_detail_cafe_bread_type, HomeListCategory.FOOD),

    @SerializedName("DESSERT")
    DESSERT(R.string.home_detail_dessert, R.string.home_detail_dessert_type, HomeListCategory.FOOD),

    @SerializedName("FAST_FOOD")
    FAST_FOOD(R.string.home_detail_fast_food, R.string.home_detail_fast_food_type, HomeListCategory.FOOD),

    @SerializedName("CHINA_FOOD")
    CHINA_FOOD(R.string.home_detail_china_food, R.string.home_detail_china_food_type, HomeListCategory.FOOD),

    @SerializedName("KOREAN_FOOD")
    KOREAN_FOOD(R.string.home_detail_korean_food, R.string.home_detail_korean_food_type, HomeListCategory.FOOD),

    @SerializedName("PIZZA")
    PIZZA(R.string.home_detail_pizza, R.string.home_detail_pizza_type, HomeListCategory.FOOD),

    @SerializedName("FOOD_EXTRA")
    FOOD_EXTRA(R.string.home_detail_extra, R.string.home_detail_extra_type, HomeListCategory.FOOD),

    @SerializedName("MART_ALL")
    MART_ALL(R.string.home_detail_all, R.string.home_detail_all_type, HomeListCategory.MART),

    @SerializedName("SNACK_BREAD")
    SNACK_AND_BREAD(R.string.home_detail_snack_and_bread, R.string.home_detail_snack_and_bread_type, HomeListCategory.MART),

    @SerializedName("BEVERAGE_COFFEE_MILK_PRODUCT")
    BEVERAGE_COFFEE_AND_MILK_PRODUCTS(R.string.home_detail_beverage_coffee_and_milk_product, R.string.home_detail_beverage_coffee_and_milk_product_type, HomeListCategory.MART),

    @SerializedName("INSTANT_COOK")
    INSATANT_COOK(R.string.home_detail_instant_cook, R.string.home_detail_instant_cook_type, HomeListCategory.MART),

    @SerializedName("WASHING_PRODUCT")
    WASHING_PRODUCTS(R.string.home_detail_washing_products, R.string.home_detail_washing_products_type, HomeListCategory.MART),

    @SerializedName("MART_EXTRA")
    MART_EXTRA(R.string.home_detail_extra, R.string.home_detail_extra_type, HomeListCategory.MART),

    @SerializedName("SERVICE_ALL")
    SERVICE_ALL(R.string.home_detail_all, R.string.home_detail_all_type, HomeListCategory.SERVICE),

    @SerializedName("HAIR_SHOP")
    HAIR_SHOP(R.string.home_detail_hair_shop, R.string.home_detail_hair_shop_type, HomeListCategory.SERVICE),

    @SerializedName("MASSAGE_AND_SKIN_CARE")
    MASSAGE_AND_SKIN_CARE(R.string.home_detail_massage_and_skin_care, R.string.home_detail_massage_and_skin_care_type, HomeListCategory.SERVICE),

    @SerializedName("STUDY_CAFE")
    STUDY_CAFE(R.string.home_detail_study_cafe, R.string.home_detail_study_cafe_type, HomeListCategory.SERVICE),

    @SerializedName("SERVICE_EXTRA")
    SERVICE_EXTRA(R.string.home_detail_extra, R.string.home_detail_extra_type, HomeListCategory.SERVICE),

    @SerializedName("FASHION_ALL")
    FASHION_ALL(R.string.home_detail_all, R.string.home_detail_all_type, HomeListCategory.FASHION),

    @SerializedName("MAN_TOP")
    MAN_TOP(R.string.home_detail_man_top, R.string.home_detail_man_top_type, HomeListCategory.FASHION),

    @SerializedName("MAN_PANTS")
    MAN_PANTS(R.string.home_detail_man_pants, R.string.home_detail_man_pants_type, HomeListCategory.FASHION),

    @SerializedName("WOMAN_TOP")
    WOMAN_TOP(R.string.home_detail_woman_top, R.string.home_detail_woman_top_type, HomeListCategory.FASHION),

    @SerializedName("WOMAN_PANTS")
    WOMAN_PANTS(R.string.home_detail_woman_pants, R.string.home_detail_woman_pants_type, HomeListCategory.FASHION),

    @SerializedName("FASHION_EXTRA")
    FASHION_EXTRA(R.string.home_detail_extra, R.string.home_detail_extra_type, HomeListCategory.FASHION),

    @SerializedName("ACCESSORY_ALL")
    ACCESSORY_ALL(R.string.home_detail_all, R.string.home_detail_all_type, HomeListCategory.ACCESSORY),

    @SerializedName("SHOES")
    SHOES(R.string.home_detail_shoes, R.string.home_detail_shoes_type, HomeListCategory.ACCESSORY),

    @SerializedName("MAN_BAG")
    MAN_BAG(R.string.home_detail_man_bag, R.string.home_detail_man_bag_type, HomeListCategory.ACCESSORY),

    @SerializedName("WOMAN_BAG")
    WOMAN_BAG(R.string.home_detail_woman_bag, R.string.home_detail_woman_bag_type, HomeListCategory.ACCESSORY),

    @SerializedName("EARRINGS")
    EARRINGS(R.string.home_detail_earrings, R.string.home_detail_earrings_type, HomeListCategory.ACCESSORY),

    @SerializedName("ACCESSORY_EXTRA")
    ACCESSORY_EXTRA(R.string.home_detail_extra, R.string.home_detail_extra_type, HomeListCategory.ACCESSORY),

    @SerializedName("ETC_ALL")
    ETC_ALL(R.string.home_detail_etc_all, R.string.home_detail_etc_all, HomeListCategory.ETC)
}