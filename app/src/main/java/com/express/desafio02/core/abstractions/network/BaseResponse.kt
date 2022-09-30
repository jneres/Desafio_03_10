package com.express.desafio02.core.abstractions.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaseResponse<T>(
    @SerializedName("payload")
    var payload: T?

) : Serializable

data class ErrorResponse(
    @SerializedName("isSuccess")
    var isSuccess: Boolean,

    @SerializedName("failureReason")
    var failureReason: String

) : Serializable