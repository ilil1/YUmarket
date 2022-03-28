package com.example.YUmarket.data.repository.myinfo

import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.customerservicelist.CSModel
import com.example.YUmarket.screen.myinfo.customerservice.list.CSCategory
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @주 허희태
 * @부 김건우 정남진 김도엽
 * @since
 * @throws
 * @description
 */


class DefaultCSRepository(
    private val ioDispatcher: CoroutineDispatcher //나중에 api용
) : CSRepository {


    override fun findCsByCategory(csCategory: CSCategory): List<CSModel> {
        return when (csCategory) {
            CSCategory.LOGIN -> listOf(
                CSModel(
                    0,
                    CellType.CUSTOMER_SERVICE_CELL,
                    0,
                    csTitle = "   로그인 오류시 이용방법                                                ",
                    csCategory = CSCategory.LOGIN,
                    csAuthor = "관리자",
                    csContent = "이 글은 로그인 오류시 이용방법 입니다"
                )


            )

            CSCategory.USE -> listOf(
                CSModel(
                    1,
                    CellType.CUSTOMER_SERVICE_CELL,
                    0,
                    csTitle = "   애플리케이션 이용방법                                        ",
                    csCategory = CSCategory.USE,
                    csAuthor = "관리자",
                    csContent = "이 글은 애플리케이션 이용방법 입니다"
                )

            )

            CSCategory.ORDER -> listOf(
                CSModel(
                    2,
                    CellType.CUSTOMER_SERVICE_CELL,
                    0,
                    csTitle = "   주문오류시 이용방법                                        ",
                    csCategory = CSCategory.ORDER,
                    csAuthor = "관리자",
                    csContent = "이 글은 주문오류시 이용방법 입니다"

                )
            )

            CSCategory.REVIEW -> listOf(
                CSModel(
                3,
                CellType.CUSTOMER_SERVICE_CELL,
                0,
                csTitle = "   리뷰오류시 이용방법                                        ",
                csCategory = CSCategory.REVIEW,
                csAuthor = "관리자",
                csContent = "이 글은 리뷰오류시 이용방법 입니다"
                )
            )


            CSCategory.ETC -> listOf(
                CSModel(
                    4,
                    CellType.CUSTOMER_SERVICE_CELL,
                    0,
                    csTitle = "   기타 오류시 이용방법                                        ",
                    csCategory = CSCategory.ETC,
                    csAuthor = "관리자",
                    csContent = "이 글은 기타오류시 이용방법 입니다"
                )
            )
        }


//        val csList = listOf(
//            CSModel(
//                0,
//                CellType.CUSTOMER_SERVICE_CELL,
//                0,
//                csTitle = "   고객센터 이용방법                                        ",
//                csCategory = CSCategory.USE,
//                csAuthor = "관리자",
//                csContent = "이 글은 고객센터 이용방법 입니다"
//            ),
//
//            CSModel(
//                1,
//                CellType.CUSTOMER_SERVICE_CELL,
//                1,
//                csTitle = "   주문오류시 이용방법                                        ",
//                csCategory = CSCategory.ORDER,
//                csAuthor = "관리자",
//                csContent = "이 글은 주문오류시 이용방법 입니다"
//            ),
//
//            CSModel(
//                2,
//                CellType.CUSTOMER_SERVICE_CELL,
//                2,
//                csTitle = "   리뷰 오류시 이용방법                                           ",
//                csCategory = CSCategory.REVIEW,
//                csAuthor = "관리자",
//                csContent = "이 글은 리뷰 오류시 입니다"
//            ),
//
//
//            CSModel(
//                3,
//                CellType.CUSTOMER_SERVICE_CELL,
//                3,
//                csTitle = "   로그인 오류시 이용방법                                                ",
//                csCategory = CSCategory.LOGIN,
//                csAuthor = "관리자",
//                csContent = "이 글은 로그인 오류시 이용방법 입니다"
//            ),
//
//            CSModel(
//                4,
//                CellType.CUSTOMER_SERVICE_CELL,
//                4,
//                csTitle = "   이용 오류시 이용방법                                           ",
//                csCategory = CSCategory.USE,
//                csAuthor = "관리자",
//                csContent = "이 글은 이용 오류시 이용방법 입니다"
//            ),
//
//            CSModel(
//                5,
//                CellType.CUSTOMER_SERVICE_CELL,
//                5,
//                csTitle = "   기타 오류시 이용방법                                           ",
//                csCategory = CSCategory.ETC,
//                csAuthor = "관리자",
//                csContent = "이 글은 기타 오류시 입니다"
//            ),
//        )
        return emptyList()
    }
}









