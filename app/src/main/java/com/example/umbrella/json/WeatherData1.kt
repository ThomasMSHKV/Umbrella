package com.example.umbrella.json

data class WeatherData1(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Any>,
    val message: Double
)