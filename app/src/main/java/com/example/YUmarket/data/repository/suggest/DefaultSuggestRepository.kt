package com.example.YUmarket.data.repository.suggest

import com.example.YUmarket.R
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.homelist.SuggestItemModel
import com.example.YUmarket.model.homelist.category.SuggestCategory

class DefaultSuggestRepository : SuggestRepository {


    override fun seasonMarket(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/5e922b43-5fbf-478a-b3f8-b441937cba37/image.png",
                "필터청소",
                0.7f,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/7c3f2b09-08cb-4b36-9515-c63122c3aaaf/image.png",
                "에어컨 수리",
                0.5F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/eb96be15-184e-494d-addb-16c84d4e8418/image.jpg",
                "방문 세차",
                1.2F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/4109fcdf-df3a-4e6c-9653-2d7df4da9554/image.jpg",
                "이사",
                2.5F,
                SuggestCategory.SEASON_SPRING
            )
        )
        return mockList
    }

    override fun fixMarket(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/79cff16b-4e9a-456d-86d8-cc189a5fb6a0/image.jpg",
                "필터청소",
                0.7f,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/5e922b43-5fbf-478a-b3f8-b441937cba37/image.png",
                "에어컨 수리",
                0.5F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/eb96be15-184e-494d-addb-16c84d4e8418/image.jpg",
                "방문 세차",
                1.2F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/4109fcdf-df3a-4e6c-9653-2d7df4da9554/image.jpg",
                "이사",
                2.5F,
                SuggestCategory.SEASON_SPRING
            )
        )
        return mockList
    }
/*
    override fun suggestBirth(): List<SuggestItemModel> {

        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "향수",
                0.7F,
                SuggestCategory.BIRTH
                ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "건강",
                0.5F,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "리셀 매장(명품)",
                1.2F,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "IT매장",
                2.5F,
                SuggestCategory.BIRTH
            )
        )
        return mockList
    }*/

    override fun suggestAnniversary(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/15d68f46-d77d-4855-8f1c-b79cb2f344a5/image.png",
                "꽃집",
                2.7f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/d01a1d2b-c11f-4ed2-a000-7db06a7b8ce6/image.png",
                "케이크",
                1.2f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                2,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/eef318df-f989-4eb0-b75a-55b8e3301dcd/image.png",
                "파티룸",
                0.9f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/b65be986-91ab-427d-ae9e-259c05d239db/image.png",
                "장난감 가게",
                1.5f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/01750680-a819-4982-9368-9c682852edc2/image.jpg",
                "레스토랑",
                1.2f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                5,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/e4b0a8ab-66e2-4f8d-a983-85324f5c0133/image.png",
                "쥬얼리",
                1.5f,
                SuggestCategory.ANNIVERSARY
            )
        )
        return mockList
    }

    override fun suggestHobby(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/17288dbc-e6bf-48be-be7d-259ff6191161/image.png",
                "노래 레슨",
                2.7f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/2119a66f-75a4-4252-a60a-ab8765f86a78/image.png",
                "골프",
                1.2f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                2,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/ec6b067e-26d3-4f62-8339-847217298810/image.png",
                "영상 편집",
                0.9f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/ec6b067e-26d3-4f62-8339-847217298810/image.png",
                "요리 교실",
                1.5f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/d91cc826-4bf1-44da-9cd8-4e0cb6c85f97/image.png",
                "헬스",
                3.5f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                5,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/90adff0f-7948-4eb0-b32b-022537958673/image.png",
                "필라테스",
                0.4f,
                SuggestCategory.HOBBY
            ),
        )
        return mockList
    }
}