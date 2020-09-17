package com.example.umbrella.data


data class Weather(
    val rates: Rates
)
data class Rates(
    val name: String,
    val description: String

)