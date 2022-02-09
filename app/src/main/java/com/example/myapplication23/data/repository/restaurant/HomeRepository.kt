package com.example.myapplication23.data.repository.restaurant

import com.example.myapplication23.model.homelist.HomeItemModel
import com.example.myapplication23.screen.home.homelist.HomeCategory


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