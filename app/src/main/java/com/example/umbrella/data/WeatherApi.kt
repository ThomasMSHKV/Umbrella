package com.example.umbrella.data


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val apiKey = "5fc05d7c39b4fe7adeec21be43dad804\n"
const val url = "api.openweathermap.org/data/2.5/weather?q=Moscow&appid=5fc05d7c39b4fe7adeec21be43dad804"

//http://api.openweathermap.org/data/2.5/weather?q=London&appid=5fc05d7c39b4fe7adeec21be43dad804

interface WeatherApi {

    @GET("weather")
    fun getWeather(
        @Query("q") name: String?,
        @Query("apiKey") apiKey: String
    ): Call<Weather>



    //    fun getWeather() : Call<WeatherData>


}