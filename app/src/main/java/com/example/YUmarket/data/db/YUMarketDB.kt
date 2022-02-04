package com.example.YUmarket.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.YUmarket.data.db.dao.BasketDao
import com.example.YUmarket.data.db.dao.LikeItemDao
import com.example.YUmarket.data.db.dao.LikeMarketDao
import com.example.YUmarket.data.entity.room.BasketEntity

@Database(
    entities = [BasketEntity::class],
    version = 1,
    exportSchema = false
)
abstract class YUMarketDB : RoomDatabase() {

    abstract val basketDao: BasketDao
    abstract val likeMarketDao: LikeMarketDao
    abstract val likeItemDao: LikeItemDao

    companion object {
        const val DB_NAME = "YUMarketDB.db"
    }
}