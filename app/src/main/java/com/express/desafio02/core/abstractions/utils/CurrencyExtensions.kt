package com.express.desafio02.core.abstractions.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.toCurrency(code: Boolean = true): String = (if (code) "R$ " else "") + DecimalFormat("#,##0.00",
    DecimalFormatSymbols(Locale("pt", "BR"))).format(this)

fun BigDecimal.toCurrency(code: Boolean = true): String = (if (code) "R$ " else "") +DecimalFormat("#,##0.00",
    DecimalFormatSymbols(Locale("pt", "BR"))).format(this)

fun Int.toCurrency(code: Boolean = true): String = (if (code) "R$ " else "") + DecimalFormat("#,##0.00",
    DecimalFormatSymbols(Locale("pt", "BR"))).format(this.toDouble())

fun Long.toCurrency(code: Boolean = true): String = (if (code) "R$ " else "") + DecimalFormat("#,##0.00",
    DecimalFormatSymbols(Locale("pt", "BR"))).format(this.toDouble())

