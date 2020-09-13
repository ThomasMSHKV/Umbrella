package com.example.umbrella.data

import retrofit2.Call
import retrofit2.http.GET

interface WeatherAPI {

    @GET("api.openweathermap.org/data/2.5/weather?q={city name}&appid={131b2691fd09d25e38b98ca3f1b8eae0\\n}")
    fun getWeather(): Call<Weather>
}