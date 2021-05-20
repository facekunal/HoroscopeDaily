package com.example.temp.api

import com.example.temp.model.Horoscope
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {
    @GET("today/{horoscopeName}")
    suspend fun getHoroscope(@Path("horoscopeName") horoscopeName: String): Response<Horoscope>
}