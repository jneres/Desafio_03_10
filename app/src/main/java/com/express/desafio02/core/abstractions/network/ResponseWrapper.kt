package com.express.desafio02.core.abstractions.network

sealed class ResponseWrapper<out T> {
    data class Success<out T>(val value: T): ResponseWrapper<T>()
    data class Error<out T>(val code: Int? = null, val error: String = ""): ResponseWrapper<T>()
    data class Unauthorized<out T>(val code: Int? = null): ResponseWrapper<T>()
}