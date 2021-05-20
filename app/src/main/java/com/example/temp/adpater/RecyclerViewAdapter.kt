package com.example.temp.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.temp.R
import com.example.temp.model.Horoscope
import kotlinx.android.synthetic.main.item_horoscope.view.*

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<Horoscope> = ArrayList(20)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeatherViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is WeatherViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addData(horoscope: Horoscope) {
        items.add(horoscope)
        notifyItemInserted(itemCount-1)
    }

    class WeatherViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        //val date = itemView.date
        val horoscopeText = itemView.horoscopeText
        val sunsign = itemView.sunsignText

        fun bind(horoscope: Horoscope) {
            horoscopeText.text = horoscope.horoscopeText
            sunsign.text = horoscope.sunsign
        }
    }
}