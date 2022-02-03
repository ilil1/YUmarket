package com.example.YUmarket.data.repository.restaurant

import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.model.homelist.TownMarketModel
import com.example.YUmarket.model.homelist.category.HomeListCategory

/**
 * HomeListFragment의 Item에 대한 repository
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 */
interface HomeRepository {

    // TODO Spring과 연결 후 service와 연결해야함

    /** HomeListCategory에 따라서 분기하여 해당하는 아이템들을 모두 호출하는 메서드 */
    fun findItemsByCategory(homeListCategory: HomeListCategory): List<HomeItemModel>

    // 페이징 처리를 통해 동네마켓의 리스트를 불러오는 메소드 (since 2022/01/28)
    suspend fun getMarketListByPage(page: Int) : List<TownMarketModel>?
}