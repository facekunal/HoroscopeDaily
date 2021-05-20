package com.example.temp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.temp.model.Horoscope
import com.example.temp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(val repository: Repository): ViewModel() {
    val response: MutableLiveData<Response<Horoscope>> = MutableLiveData()

    fun getPost(horoscopeName: String) {
        viewModelScope.launch {
            response.value = repository.getHoroscope(horoscopeName)
        }
    }
}