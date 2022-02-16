package com.example.YUmarket.data.exceptions

/**
 * 정의되지 않은 에러에 대한 Exception class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/31
 */
class UndefinedErrorException(
    override val message: String
) : BusinessException(message, errorCode = ErrorCode.UNDEFINED_ERROR) {


}