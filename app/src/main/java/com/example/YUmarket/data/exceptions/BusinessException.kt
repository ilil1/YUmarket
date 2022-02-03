package com.example.YUmarket.data.exceptions

/**
 * RuntimeException을 상속받는 사용자 정의 예외의 최상단 예외
 * @author Doyeop Kim (main)
 * @since 2022/01/31
 */
open class BusinessException(
    override val message: String,
    val errorCode: ErrorCode
) : RuntimeException() {


}