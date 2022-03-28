package com.example.YUmarket.screen.myinfo.customerservice.list

import androidx.annotation.StringRes
import com.example.YUmarket.R

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

enum class CSCategory(
    @StringRes val categoryNameId: Int,
    @StringRes val categoryTypeId: Int
) {
    LOGIN(R.string.login, R.string.login_type),
    USE(R.string.use, R.string.use_type),
    ORDER(R.string.order, R.string.order_type),
    REVIEW(R.string.review, R.string.review_type),
    ETC(R.string.etc, R.string.etc_type)


}