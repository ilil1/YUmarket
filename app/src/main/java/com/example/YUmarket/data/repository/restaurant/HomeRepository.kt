package com.example.YUmarket.data.repository.restaurant

import com.example.YUmarket.model.homelist.HomeItemModel
import com.example.YUmarket.screen.home.homelist.HomeCategory


/**
 * HomeListFragment의 Item에 대한 repository
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/18
 */
interface HomeRepository {
    // TODO Entity?
    fun getList(homeCategory: HomeCategory) : List<HomeItemModel>
}