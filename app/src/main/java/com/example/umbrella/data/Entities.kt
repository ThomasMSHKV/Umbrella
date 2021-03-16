package com.example.umbrella.data

import com.google.gson.annotations.SerializedName


data class WeatherData(

    val weather: List<Weather>,
    val main : Main,
    val wind: Wind
)

data class Weather(
    @SerializedName("description") val description: String,
    @SerializedName("main") val main: String,
    @SerializedName("name") val name: Name
)

data class Main(
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val feels_like: Double,
    @SerializedName("temp_min") val  temp_min: Double,
    @SerializedName("temp_max") val temp_max: Double
)


data class Name(
    @SerializedName("name") val name: String

)

data class Wind(
    @SerializedName("speed") val speed: Int

)




