package com.example.myapplication23.model.homelist

import com.example.myapplication23.model.CellType
import com.example.myapplication23.model.Model
import com.example.myapplication23.screen.home.homelist.HomeCategory

data class HomeItemModel(
    override val id: Long,
    val title: String,
    val category: HomeCategory,
    // TODO add more
    override val type: CellType = CellType.RESTAURANT_CELL,
) : Model(id, type)
