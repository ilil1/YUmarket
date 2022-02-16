package com.example.YUmarket.util.mapper

import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.data.response.home.homeItem.HomeItemDetailResponseDto
import com.example.YUmarket.data.response.home.townMarket.TownMarketResponseDto
import com.example.YUmarket.data.response.home.townMarket.TownMarketSimpleResponseDto
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.model.homelist.TownMarketModel
import com.example.YUmarket.util.parser.TimeParser

/**
 * Dto를 Model로 변환을 해주는 mapper class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/28
 * */
object ModelMapper {

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

    // ItemDetailResponse를 HomeItemModel로 변환시키는 메소드
    fun transformItemDetailDtoToModel(responseDto: HomeItemDetailResponseDto) : HomeItemModel {

        return HomeItemModel(
            id = responseDto.id,
            homeListCategory = responseDto.category,
            homeListDetailCategory = responseDto.detailCategory,
            itemImageUrl = responseDto.itemImageUrl,
            itemName = responseDto.name,
            originalPrice = responseDto.originalPrice,
            salePrice = responseDto.salePrice,
            stockQuantity = responseDto.stockQuantity,
            likeQuantity = responseDto.likeQuantity,
            reviewQuantity = responseDto.reviewQuantity,
            townMarketModel = transformSimpleMarketToModel(responseDto.marketInfo)
        )
    }

    // HomeListFragment에서 HomeItem을 띄울 시 필요없는 정보들은 모두 가짜 데이터로 padding한 상태로 TownMarketModel을 리턴하는 메소드
    private fun transformSimpleMarketToModel(responseDto: TownMarketSimpleResponseDto) : TownMarketModel {
        return TownMarketModel(
            id = responseDto.id,
            locationLatLngEntity = LocationLatLngEntity(latitude = responseDto.latitude, longitude = responseDto.longitude),
            marketName = responseDto.name,
            isMarketOpen = false,
            distance = 0.0f,
            itemQuantity = 0,
            likeQuantity = 0,
            reviewQuantity = 0,
            openTime = null,
            closeTime = null,
            marketImageUrl = null
        )
    }
}