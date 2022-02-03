package com.example.YUmarket.model.homelist

import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.Model
import com.example.YUmarket.model.homelist.category.HomeListCategory
import java.time.LocalTime

/**
 * 동네마켓 아이템을 정의해주는 Data Class
 * modified 2022/01/28 openTime, closeTime, itemQuantity, likeQuantity, reviewQuantity 추가
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 * @param locationLatLngEntity 해당 동네마켓의 좌표를 담는 변수
 */
data class TownMarketModel(
    override val id: Long,
    val marketName: String,
    val openTime: LocalTime?,
    val closeTime: LocalTime?,
    val isMarketOpen: Boolean,
    val locationLatLngEntity: LocationLatLngEntity,
    val marketImageUrl: String?,
    val distance: Float, // 22.01.18 거리 추가 by 정남진
    val itemQuantity: Int,
    val likeQuantity: Int,
    val reviewQuantity: Int,
    override val type: CellType = CellType.HOME_TOWN_MARKET_CELL
) : Model(id, type)
