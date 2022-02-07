package com.example.YUmarket.data.repository.restaurant

import android.util.Log
import com.example.YUmarket.data.exceptions.EntityNotFoundException
import com.example.YUmarket.data.exceptions.UndefinedErrorException
import com.example.YUmarket.data.network.home.TownMarketApiService
import com.example.YUmarket.data.response.common.BaseResponse
import com.example.YUmarket.data.response.common.ErrorResponse
import com.example.YUmarket.data.response.home.townMarket.TownMarketResponseDto
import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.model.homelist.TownMarketModel
import com.example.YUmarket.model.homelist.category.HomeListCategory
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
//            )
//
//            HomeListCategory.MART -> listOf(
//                HomeItemModel(
//                    0,
//                    HomeListCategory.MART,
//                    HomeListDetailCategory.SNACK_AND_BREAD,
//                    "https://picsum.photos/200",
//                    TownMarketModel(
//                        3,
//                        "빅마트",
//                        true,
//                        LocationLatLngEntity(128.0, 36.0),
//                        "https://picsum.photos/200",
//                        0.11f
//                    ),
//                    "초코송이",
//                    1500,
//                    800,
//                    5,
//                    5,
//                    5
//                ),
//                HomeItemModel(
//                    1,
//                    HomeListCategory.MART,
//                    HomeListDetailCategory.WASHING_PRODUCTS,
//                    "https://picsum.photos/200",
//                    TownMarketModel(
//                        3,
//                        "빅마트",
//                        true,
//                        LocationLatLngEntity(128.0, 36.0),
//                        "https://picsum.photos/200",
//                        0.11f
//                    ),
//                    "샤프란",
//                    4000,
//                    3500,
//                    3,
//                    3,
//                    2
//                ),
//                HomeItemModel(
//                    2,
//                    HomeListCategory.MART,
//                    HomeListDetailCategory.MART_EXTRA,
//                    "https://picsum.photos/200",
//                    TownMarketModel(
//                        3,
//                        "빅마트",
//                        true,
//                        LocationLatLngEntity(128.0, 36.0),
//                        "https://picsum.photos/200",
//                        0.11f
//                    ),
//                    "아이스티 분말",
//                    5000,
//                    4300,
//                    7,
//                    5,
//                    2
//                ),
//                HomeItemModel(
//                    3,
//                    HomeListCategory.MART,
//                    HomeListDetailCategory.SNACK_AND_BREAD,
//                    "https://picsum.photos/200",
//                    TownMarketModel(
//                        3,
//                        "빅마트",
//                        true,
//                        LocationLatLngEntity(128.0, 36.0),
//                        "https://picsum.photos/200",
//                        0.11f
//                    ),
//                    "포테이토칩",
//                    1300,
//                    1200,
//                    5,
//                    5,
//                    5
//                )
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

    /**
     * 페이징 처리를 통해 동네마켓의 리스트를 불러오는 메소드
     * @author Doyeop Kim (main)
     * Sub 김건우, 김도엽, 배은호, 허희태
     * @since 22.01.31
     */
    override suspend fun getMarketListByPage(page: Int): List<TownMarketModel> = withContext(ioDispatcher) {
        val response = townMarketApiService.getList(page)

        // Log
        Log.d("getMarketList", response.body().toString())

        if(response.isSuccessful) {
            val responseBody = response.body() as BaseResponse<List<TownMarketResponseDto>>
            val data = responseBody.data

            data!!.map { townMarketResponseDto ->
                ModelMapper.transformMarketDtoToModel(townMarketResponseDto)
            }.toList()
        } else {
            // TODO 22.02.07 (김도엽) 예외 처리 다시 구현 -> TownMarketApiService에 에러 전용 메소드 구현
            val responseBody = response.body() as ErrorResponse
            when(responseBody.code) {
                "ENTITY_NOT_FOUND" -> throw EntityNotFoundException("해당 데이터가 존재하지 않습니다")
                else -> throw UndefinedErrorException("정의되지 않은 에러입니다")
            }
        }
    }

    // TODO 22.02.07 (김도엽) HomeItem에 대한 메소드 구현

    // TODO 22.01.25 임시로 만든 Method 나중에 제대로 구현
    override fun getAllNewSaleItems(): List<HomeItemModel> {
        val result = mutableListOf<HomeItemModel>()
        val categories = HomeListCategory.values().drop(1)

        categories.forEach {
            result.addAll(findItemsByCategory(it))
        }

        return result
    }
}
