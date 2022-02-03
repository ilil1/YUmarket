package com.example.YUmarket.data.exceptions

/**
 *
 * @author Doyeop Kim
 * @since 2022/01/31
 */
class UndefinedErrorException(
    override val message: String
) : BusinessException(message, errorCode = ErrorCode.UNDEFINED_ERROR){


}