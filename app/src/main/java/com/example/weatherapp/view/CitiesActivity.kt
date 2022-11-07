package com.example.weatherapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.adapter.CityAdapter
import com.example.weatherapp.model.City

class CitiesActivity : AppCompatActivity() {

    private val list: MutableList<City> = mutableListOf()
    private lateinit var adapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        val recyclerView = findViewById<RecyclerView>(R.id.city_list)
        adapter = CityAdapter(layoutInflater) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", it.name)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.submitList(null)

    }

    override fun onStart() {
        super.onStart()

        adapter.submitList(MainActivity.listOfCities)
    }
}