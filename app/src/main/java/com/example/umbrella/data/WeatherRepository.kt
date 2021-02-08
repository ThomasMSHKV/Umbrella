package com.example.umbrella.data

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class WeatherRepository : CoroutineScope {
    override val coroutineContext = Dispatchers.IO

    private fun httpClient(): OkHttpClient {
        val client = OkHttpClient()
        return client.newBuilder()
            .retryOnConnectionFailure(true)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .callTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(buildLoggingInterceptor())
            .build()
    }

    private fun buildLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    private val weatherApi: WeatherApi = Retrofit.Builder()

        .baseUrl("http://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient())
        .build()
        .create(WeatherApi::class.java)


    fun getData(name: String?) = async {
        weatherApi.getWeather(name, "5fc05d7c39b4fe7adeec21be43dad804", "metric")
            .execute()
            .body()
    }

}