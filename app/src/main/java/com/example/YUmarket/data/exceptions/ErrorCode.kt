package com.example.YUmarket.data.exceptions

/**
 *
 * @author Doyeop Kim
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