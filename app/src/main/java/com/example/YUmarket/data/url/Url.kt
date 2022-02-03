package com.example.YUmarket.data.url

object Url {
    const val TMAP_URL = "https://apis.openapi.sk.com"

    const val GET_TMAP_POIS_AROUND = "/tmap/pois/search/around"
    const val GET_TMAP_REVERSE_GEO_CODE = "/tmap/geo/reversegeocoding"

    // ===============Request urls made by Doyeop Kim (since 2022/01/28)===============

    // base url
    const val YU_MARKET_URL = "https://11ed-221-164-244-82.ngrok.io"

    // urls about town-market
    const val TOWN_MARKET = "/api/town-market"
    const val TOWN_MARKET_DETAIL = "$TOWN_MARKET/detail"
    const val TOWN_MARKET_LIST = "$TOWN_MARKET/list"
    const val MARKET_LIKE = "$TOWN_MARKET-like"
    const val MARKET_REVIEW = "$TOWN_MARKET-review"

    // urls about home-item
    const val HOME_ITEM = "/api/item"
}