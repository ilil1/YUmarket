package com.example.YUmarket.data.repository.restaurant

import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.data.exceptions.BusinessException
import com.example.YUmarket.data.exceptions.EntityNotFoundException
import com.example.YUmarket.data.exceptions.ErrorCode
import com.example.YUmarket.data.exceptions.UndefinedErrorException
import com.example.YUmarket.data.network.home.TownMarketApiService
import com.example.YUmarket.data.response.common.BaseResponse
import com.example.YUmarket.data.response.common.ErrorResponse
import com.example.YUmarket.data.response.home.TownMarketResponseDto
import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.model.homelist.TownMarketModel
import com.example.YUmarket.model.homelist.category.HomeListCategory
import com.example.YUmarket.model.homelist.category.HomeListDetailCategory
import com.example.YUmarket.util.mapper.ModelMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * HomeListFragment의 Item에 대한 repository
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 */
class DefaultHomeRepository(
    private val townMarketApiService: TownMarketApiService,
    private val ioDispatcher: CoroutineDispatcher
) : HomeRepository {

    override fun findItemsByCategory(homeListCategory: HomeListCategory): List<HomeItemModel> {
        return when (homeListCategory) {
            HomeListCategory.FOOD -> listOf(
//                HomeItemModel(
//                    0,
//                    HomeListCategory.FOOD,
//                    HomeListDetailCategory.FAST_FOOD,
//                    "https://picsum.photos/200",
//                    TownMarketModel(
//                        4,
//                        "롯데리아 영남대 DT",
//                        false,
//                        LocationLatLngEntity(128.0, 36.0),
//                        "https://picsum.photos/200",
//                        0.11f
//                    ),
//                    "폴더버거",
//                    5300,
//                    5100,
//                    30,
//                    5,
//                    5
//                ),
//                HomeItemModel(
//                    1,
//                    HomeListCategory.FOOD,
//                    HomeListDetailCategory.FAST_FOOD,
//                    "https://picsum.photos/200",
//                    TownMarketModel(
//                        4,
//                        "롯데리아 영남대 DT",
//                        false,
//                        LocationLatLngEntity(128.0, 36.0),
//                        "https://picsum.photos/200",
//                        0.11f
//                    ),
//                    "핫크리스피 버거",
//                    4800,
//                    4500,
//                    30,
//                    5,
//                    5
//                ),
//                HomeItemModel(
//                    2,
//                    HomeListCategory.FOOD,
//                    HomeListDetailCategory.FAST_FOOD,
//                    "https://picsum.photos/200",
//                    TownMarketModel(
//                        4,
//                        "롯데리아 영남대 DT",
//                        false,
//                        LocationLatLngEntity(128.0, 36.0),
//                        "https://picsum.photos/200",
//                        0.11f
//                    ),
//                    "불고기버거",
//                    3800,
//                    3800,
//                    30,
//                    5,
//                    5
//                )
            )

            HomeListCategory.MART -> listOf(

            )

            HomeListCategory.FASHION -> listOf(

            )

            HomeListCategory.ACCESSORY -> listOf(

            )

            HomeListCategory.SERVICE -> listOf(

            )

            HomeListCategory.ETC -> listOf()

            else -> listOf()
        }
    }

    override suspend fun getMarketListByPage(page: Int): List<TownMarketModel>? = withContext(ioDispatcher) {
        val response = townMarketApiService.getList(page)

        if(response.isSuccessful) {
            val responseBody = response.body() as BaseResponse<List<TownMarketResponseDto>>
            val data = responseBody.data

            data!!.map { townMarketResponseDto ->
                ModelMapper.transformMarketDtoToModel(townMarketResponseDto)
            }.toList()
        } else {
            val responseBody = response.body() as ErrorResponse
            when(responseBody.code) {
                "ENTITY_NOT_FOUND" -> throw EntityNotFoundException("해당 데이터가 존재하지 않습니다")
                else -> throw UndefinedErrorException("정의되지 않은 에러입니다")
            }
        }
    }
}