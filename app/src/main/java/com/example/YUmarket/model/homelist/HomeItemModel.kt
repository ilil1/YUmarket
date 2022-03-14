package com.example.YUmarket.model.homelist

import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.Model
import com.example.YUmarket.screen.home.homelist.HomeCategory

data class HomeItemModel(
    override val id: Long,
    val title: String,
    val category: HomeCategory,
    // TODO add more
    override val type: CellType = CellType.HOME_ITEM_CELL,
) : Model(id, type)
