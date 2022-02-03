package com.example.YUmarket.model.homelist

import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.Model
import com.example.YUmarket.model.homelist.category.HomeListCategory
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * 동네마켓 아이템을 정의해주는 Data Class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 * @param locationLatLngEntity 해당 동네마켓의 좌표를 담는 변수
 */
data class TownMarketModel(
    override val id: Long,
    val marketName: String,
    val openTime: LocalTime?, // 2022/01/28 오픈 시간 추가 by 김도엽
    val closeTime: LocalTime?, // 2022/01/28 마감 시간 추가 by 김도엽
    val isMarketOpen: Boolean, // 2022/01/28 nullable 수정
    val locationLatLngEntity: LocationLatLngEntity,
    val marketImageUrl: String?, // 2022/01/28 nullable 수정
    val distance: Float, // 22.01.18 거리 추가 by 정남진,
    val itemQuantity: Int, // 2022/01/28 상품 수량 추가 by 김도엽
    val likeQuantity: Int, // 2022/01/28 찜 개수 추가 by 김도엽
    val reviewQuantity: Int, // 2022/01/28 리뷰 개수 추가 by 김도엽
    override val type: CellType = CellType.HOME_TOWN_MARKET_CELL
) : Model(id, type)
