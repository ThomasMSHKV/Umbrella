package com.example.umbrella.data


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val apiKey = "a7403b2d22bb088b0e97b5f6330bfadf"
const val url = "weather"

//http://api.openweathermap.org/data/2.5/weather?q=Dubai&appid=5fc05d7c39b4fe7adeec21be43dad804&units=metric

//http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=5fc05d7c39b4fe7adeec21be43dad804&units=metric

//https://api.openweathermap.org/data/2.5/weather?q=London&units=metric&appid=5fc05d7c39b4fe7adeec21be43dad804
interface WeatherApi {

    @GET(url)
    fun getWeather(
        @Query("q") name: String?,
        @Query("appid") appid: String,
        @Query("units") units: String
    ): Call<WeatherData>





}