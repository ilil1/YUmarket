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

    /** HomeListCategory에 따라서 분기하여 해당하는 아이템들을 모두 호출하는 메서드 */
    fun findItemsByCategory(homeListCategory: HomeListCategory): List<HomeItemModel>

    /**
     * 새로 등록된 모든 할인 상품을 가져오는 Method
     * @author Main 정남진, Sub 김건우, 김도엽, 배은호, 허희태
     * @since 22.01.25
     * @return 새로 등록된 모든 할인 상품 List
     */
    fun getAllNewSaleItems(): List<HomeItemModel>

    /**
     * 페이징 처리를 통해 동네마켓의 리스트를 불러오는 메소드
     * @author Doyeop Kim (main)
     * Sub 김건우, 김도엽, 배은호, 허희태
     * @since 22.01.31
     */
    suspend fun getMarketListByPage(page: Int) : List<TownMarketModel>?

    /**
     * 페이징 처리를 통해 HomeItem의 리스트를 불러오는 메소드
     * @author Doyeop Kim (main)
     * Sub 김건우, 김도엽, 배은호, 허희태
     * @since 22.01.31
     */
    suspend fun getItemListByPageAndCategory(page: Int, category: HomeListCategory) : List<HomeItemModel>?
}