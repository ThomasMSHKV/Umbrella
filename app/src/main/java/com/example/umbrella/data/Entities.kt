package com.example.umbrella.data

import com.google.gson.annotations.SerializedName

data class Weather(
    val weatherData: WeatherData

)

data class WeatherData(
    @SerializedName("description")
    val description: String,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("speed")
    val speed: Int,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("temp")
    val temp: Int,
    @SerializedName("sunset")
    val sunset: Int,
    @SerializedName("name")
    val name: String

)


