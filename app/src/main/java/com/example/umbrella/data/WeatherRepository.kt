package com.example.umbrella.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class WeatherRepository: CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    private val weatherApi = Retrofit.Builder()
        .baseUrl("https://openweathermap.org/current")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    fun getWeather() = async {
        weatherApi.getWeather()
    }

}