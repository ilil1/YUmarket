package com.example.YUmarket.data.db.dao

import androidx.room.*
import com.example.YUmarket.data.entity.room.LikeMarketEntity

@Dao
interface LikeMarketDao {
    // 최근에 추가한 항목이 위로 오도록
    @Query("select * from LikeMarketEntity order by id desc")
    suspend fun getAll(): List<LikeMarketEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: LikeMarketEntity)

    @Delete
    suspend fun delete(item: LikeMarketEntity)

    @Query("delete from LikeMarketEntity")
    suspend fun deleteAll()
}