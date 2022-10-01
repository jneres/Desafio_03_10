package com.express.desafio02.features.home.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.math.BigDecimal

data class HomeResponse(
    @SerializedName("people")
    var people: ArrayList<People>?,

    @SerializedName("date")
    var date: BigDecimal? = BigDecimal.ZERO,

    @SerializedName("description")
    var description: String? = "",

    @SerializedName("image")
    var image: String? = "",

    @SerializedName("longitude")
    var longitude: Double? = 0.0,

    @SerializedName("latitude")
    var latitude: Double? = 0.0,

    @SerializedName("price")
    var price: Double? = 0.0,

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("id")
    var idItem: Int

) : Serializable
