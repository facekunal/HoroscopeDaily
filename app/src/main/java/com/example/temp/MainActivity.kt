package com.example.temp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.temp.adpater.RecyclerViewAdapter
import com.example.temp.model.Horoscope
import com.example.temp.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var weatherAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initRecyclerView()
    }

    private fun initData() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost("aquarius")
        viewModel.getPost("pisces")
        viewModel.getPost("aries")
        viewModel.getPost("taurus")
        viewModel.getPost("gemini")
        viewModel.getPost("cancer")
        viewModel.getPost("leo")
        viewModel.getPost("virgo")
        viewModel.getPost("libra")
        viewModel.getPost("scorpio")
        viewModel.getPost("sagittarius")
        viewModel.getPost("capricorn")
        viewModel.response.observe(this, Observer {
            if(it.isSuccessful) {
                Log.i("MainActivity", "successful ${it.body()?.sunsign}")
                addRecyclerViewData(it.body()!!)
            } else {
                Log.i("MainActivity", "unsuccessful")
            }
        })
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            weatherAdapter = RecyclerViewAdapter()
            adapter = weatherAdapter
        }
    }

    private fun addRecyclerViewData(horoscope: Horoscope) {
        weatherAdapter.addData(horoscope)
    }
}