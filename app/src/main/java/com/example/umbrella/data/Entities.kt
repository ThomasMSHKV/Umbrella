package com.example.umbrella.data

import com.google.gson.annotations.SerializedName


data class Weather(

    val weatherData: WeatherData

)

data class WeatherData(
    @SerializedName("description") val description: Description,
    @SerializedName("main") val main: Main,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("name") val name: Name,
    @SerializedName("wind") val wind: Wind

)

data class Main(
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("temp") val temp: Double
)

data class Sys(
    @SerializedName("sunrise") val sunrise: Int,
    @SerializedName("sunset") val sunset: Int
)

data class Description(
    @SerializedName("description") val description: String

)

data class Name(
    @SerializedName("name") val name: String

)

data class Wind(
    @SerializedName("speed") val speed: Double

)


//data class WeatherData(
//    @SerializedName("humidity") val humidity: Int,
//    @SerializedName("pressure") val pressure: Int,
//    @SerializedName("temp") val temp: Double,
//    @SerializedName("sunrise") val sunrise: Int,
//    @SerializedName("sunset") val sunset: Int,
//    @SerializedName("name") val name: String,
//    @SerializedName("description") val description: String,
//    @SerializedName("speed") val speed: Double
//
//)


