package com.example.YUmarket.util.api

import com.example.YUmarket.data.exceptions.EntityNotFoundException
import com.example.YUmarket.data.exceptions.HttpMethodArgumentNotValidException
import com.example.YUmarket.data.response.common.BaseResponse
import com.example.YUmarket.data.response.common.ErrorResponse
import com.example.YUmarket.data.response.home.homeItem.HomeItemDetailResponseDto
import com.example.YUmarket.model.homelist.category.HomeListCategory
import retrofit2.Response
import java.lang.Exception

/**
 * YU Market의 API 통신에 대한 유틸을 제공하는 코틀린 파일
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/02/09
 * */

// exception을 처리하는 메소드
fun throwBusinessExceptions(response: Response<ErrorResponse>) {
    val responseBody = response.body()

    when(responseBody!!.code) {
        "C001" -> throw HttpMethodArgumentNotValidException(responseBody.message, responseBody.errorList!!)
        "C101" -> throw EntityNotFoundException(responseBody.message)
    }
}