package com.example.YUmarket.data.exceptions

/**
 * YU Market에서 발생할 수 있는 모든 에러의 코드를 보아둔 enum class
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/31
 */
enum class ErrorCode(
    private val status: Int,
    private val code : String,
    private val message: String
) {

    INVALID_INPUT_VALUE(400, "C001", "Invalid input value"),
    ACCESS_DENIED(400, "C002", "Access is denied"),

    ENTITY_NOT_FOUND(500, "C101", "Entity is not found"),

    UNDEFINED_ERROR(500, "C201", "Undefined error")
}