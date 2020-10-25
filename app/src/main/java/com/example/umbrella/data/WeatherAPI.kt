package com.example.umbrella.data

import retrofit2.Call
import retrofit2.http.GET

interface WeatherAPI {

    @GET("/api/location/(woeid)/")
    fun getWeather(): Call<Weather>
}