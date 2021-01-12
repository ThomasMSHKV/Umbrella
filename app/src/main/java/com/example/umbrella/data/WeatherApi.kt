package com.example.umbrella.data


import com.example.umbrella.json.WeatherData1
import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {

    @GET("/data/2.5/weather?q=London&appid=5fc05d7c39b4fe7adeec21be43dad804")
    fun getWeather(): Call<WeatherData1>
}