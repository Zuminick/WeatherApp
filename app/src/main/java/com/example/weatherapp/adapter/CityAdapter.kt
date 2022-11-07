package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.model.City

class CityAdapter(
    private val inflater: LayoutInflater,
    private val onClick: (City) -> Unit
) :
    ListAdapter<City, CityAdapter.ViewHolder>(UserDiffCallback) {

    class ViewHolder(
        view: View,
        val onClick: (City) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tv_city_name)
        private val image = view.findViewById<ImageView>(R.id.img_weather_pictures)
        private val degree = view.findViewById<TextView>(R.id.tv_degree)
        private var city: City? = null

        init {
            view.setOnClickListener {
                city?. let {
                    onClick(it)
                }
            }
        }

        fun bind(city: City) {
            this.city = city
            name.text = city.name
            degree.text = city.degree
            Glide.with(this.itemView)
                .load(city.image)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.layout_list_city, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    object UserDiffCallback : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(
            oldItem: City,
            newItem: City
        ): Boolean {

            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: City,
            newItem: City
        ): Boolean {

            return oldItem.name == newItem.name
        }
    }
}