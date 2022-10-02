package com.express.desafio02.features.home.data.model

import java.io.Serializable

data class Checkin(
    var eventId: String? = "",
    var name: String? = "",
    var email: String? = ""
) : Serializable


