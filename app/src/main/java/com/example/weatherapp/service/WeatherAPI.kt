package com.example.weatherapp.service

import com.example.weatherapp.model.WeatherModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("data/2.5/weather?&units=metric&APPID=9eaafcf2c279b8d292c9c74159d6fb88")
    fun getData(
        @Query("q") cityName: String
    ): Single<WeatherModel>


}