package com.example.YUmarket.data.exceptions

/**
 * Internal Server Error - C101 에러에 대한 Exception class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/31
 */
class EntityNotFoundException(
    override val message: String
) : BusinessException(message, errorCode = ErrorCode.ENTITY_NOT_FOUND){


}