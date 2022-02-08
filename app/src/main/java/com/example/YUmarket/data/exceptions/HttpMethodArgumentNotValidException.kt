package com.example.YUmarket.data.exceptions

/**
 * Bad Request - C001(Invalid input value)에 대한 예외를 담당하는 예외 클래스
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/02/08
 */
class HttpMethodArgumentNotValidException(
    override val message: String
) : BusinessException(message, errorCode = ErrorCode.INVALID_INPUT_VALUE){

}