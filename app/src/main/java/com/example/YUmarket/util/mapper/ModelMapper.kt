package com.example.YUmarket.util.mapper

import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.data.response.home.TownMarketResponseDto
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.homelist.TownMarketModel
import com.example.YUmarket.util.parser.TimeParser

/**
 * Dto를 Model로 변환을 해주는 mapper class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 * */
object ModelMapper {

    /**
     * data part를 전달하여 모델로 변환시키는 메소드
     * @param data response의 data part
     */
    fun map(data: Any): Any? {
        return when(data) {
            is TownMarketResponseDto -> transformMarketDtoToModel(data)
            else -> null
        }
    }

    // TownMarketResponseDto를 TownMarketModel로 변환시키는 메소드
    fun transformMarketDtoToModel(responseDto: TownMarketResponseDto) : TownMarketModel {

        val openTime = responseDto.openTime?.let {
            TimeParser.LocalTimeParser.execute(it)
        }?: kotlin.run {
            null
        }

        val closeTime = responseDto.closeTime?.let {
            TimeParser.LocalTimeParser.execute(it)
        }?:kotlin.run {
            null
        }

        return TownMarketModel(
            id = responseDto.id,
            marketName = responseDto.name,
            openTime = openTime,
            closeTime = closeTime,
            isMarketOpen = responseDto.isOpen,
            locationLatLngEntity = LocationLatLngEntity(responseDto.latitude, responseDto.longitude),
            marketImageUrl = responseDto.marketImageUrl,
            distance = 0.0f,
            itemQuantity = responseDto.itemQuantity,
            likeQuantity = responseDto.likeQuantity,
            reviewQuantity = responseDto.reviewQuantity,
            type = CellType.HOME_TOWN_MARKET_CELL
        )
    }
}