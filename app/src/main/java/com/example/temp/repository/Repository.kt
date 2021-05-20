package com.example.temp.repository

import com.example.temp.api.RetrofitInstance
import com.example.temp.model.Horoscope
import retrofit2.Response

class Repository {
    suspend fun getHoroscope(horoscopeName: String): Response<Horoscope> {
        return RetrofitInstance.api.getHoroscope(horoscopeName)
    }
}