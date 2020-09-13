package com.example.umbrella.data

import java.util.*

data class Weather(
    val rates: Rates
)
data class Rates(
    val name: String,
    val description: String

)