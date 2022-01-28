package com.example.myapplication23.data.repository.myinfo

import com.example.myapplication23.model.CellType
import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * @주 허희태
 * @부 김건우 정남진 김도엽
 * @since
 * @throws
 * @description
 */


class DefaultCSRepository(

    private val ioDispatcher:CoroutineDispatcher //나중에 api용
): CSRepository {


    override fun findCsByCategory(csCategory: CSCategory): List<CSModel> {
        return when(csCategory){
            CSCategory.TOTAL-> listOf(
                CSModel(
                    0,
                    CellType.CUSTOMER_SERVICE_CELL,
                    0,
                    csTitle = "고객센터 이용방법                                           ",
                    csCategory = CSCategory.TOTAL,
                    csAuthor = "관리자",
                    csContent = "이 글은 고객센터 이용방법 입니다"
                ),

                CSModel(
                    1,
                    CellType.CUSTOMER_SERVICE_CELL,
                    1,
                    csTitle = "주문오류시 이용방법                                           ",
                    csCategory = CSCategory.TOTAL,
                    csAuthor = "관리자",
                    csContent = "이 글은 주문오류시 이용방법 입니다"
                ),

                CSModel(
                    2,
                    CellType.CUSTOMER_SERVICE_CELL,
                    2,
                    csTitle = "리뷰 오류시 이용방법                                           ",
                    csCategory = CSCategory.TOTAL,
                    csAuthor = "관리자",
                    csContent = "이 글은 리뷰 오류시 입니다"
                ),


                CSModel(
                    3,
                    CellType.CUSTOMER_SERVICE_CELL,
                    3,
                    csTitle = "로그인 오류시 이용방법                                                ",
                    csCategory = CSCategory.TOTAL,
                    csAuthor = "관리자",
                    csContent = "이 글은 로그인 오류시 이용방법 입니다"
                ),

                CSModel(
                    4,
                    CellType.CUSTOMER_SERVICE_CELL,
                    4,
                    csTitle = "이용 오류시 이용방법                                           ",
                    csCategory = CSCategory.TOTAL,
                    csAuthor = "관리자",
                    csContent = "이 글은 이용 오류시 이용방법 입니다"
                ),

                CSModel(
                    5,
                    CellType.CUSTOMER_SERVICE_CELL,
                    5,
                    csTitle = "기타 오류시 이용방법                                           ",
                    csCategory = CSCategory.TOTAL,
                    csAuthor = "관리자",
                    csContent = "이 글은 기타 오류시 입니다"
                ),

                )
            CSCategory.ORDER -> listOf(
                CSModel(

                    id = 1,

                    csInfoId = 1,
                    csTitle = "주문 오류시 대처방법                                         ",
                    csCategory = CSCategory.ORDER,
                    csAuthor = "관리자",
                    csContent = "이 글은 주문 오류시 입니다"
                ),
            )
                CSCategory.REVIEW -> listOf(
                CSModel(
                    id = 2,
                    csInfoId = 2,
                    csTitle = "리뷰 오류시 대처방법                                         ",
                    csCategory = CSCategory.REVIEW,
                    csAuthor = "관리자",
                    csContent = "이 글은 리뷰 오류시 입니다"
                )
            )
            CSCategory.LOGIN -> listOf(
                CSModel(
                    id = 3,
                    csInfoId = 3,
                    csTitle = "로그인 오류시 대처방법                                         ",
                    csCategory = CSCategory.REVIEW,
                    csAuthor = "관리자",
                    csContent = "이 글은 예시 입니다"
                )
            )
            CSCategory.USE -> listOf(
                CSModel(
                    id = 4,
                    csInfoId =4,
                    csTitle = "이용 오류시 대처방법                                         ",
                    csCategory = CSCategory.REVIEW,
                    csAuthor = "관리자",
                    csContent = "이 글은 예시 입니다"
                )
            )

            CSCategory.ETC -> listOf(
                CSModel(
                    id = 5,
                    csInfoId = 5,
                    csTitle = "기타 오류시 대처방법                                         ",
                    csCategory = CSCategory.REVIEW,
                    csAuthor = "관리자",
                    csContent = "이 글은 예시 입니다"
                )
            )
        }
    }





}



