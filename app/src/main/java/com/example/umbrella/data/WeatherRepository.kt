package com.example.umbrella.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherRepository: CoroutineScope {
    override val coroutineContext = Dispatchers.IO
        private val weatherApi:WeatherApi = Retrofit.Builder()
            .baseUrl("https://openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)


    fun getData() = async {
        weatherApi.getWeather()
            .execute()
            .body()







            




    }

}