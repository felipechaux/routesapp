package com.example.routesapp.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.routesapp.R
import com.example.routesapp.data.dto.response.RoutesDTO
import com.example.routesapp.views.adapters.RouteAdapter

class AllRoutesActivity : AppCompatActivity() {


    //region Variables
    lateinit var listView: ListView
    private lateinit var routesView: RoutesViewModel
    //endregion

    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_routes)
        setupViewModel()
        loadExtras()
    }
    //endregion


    //region Methods
    
    //setupViewModel
    private fun setupViewModel() {
        try {
            routesView = ViewModelProvider(this)[RoutesViewModel::class.java]
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //setupViewModel
    private fun loadExtras() {
        try {
            val codeUser: String? = intent.getStringExtra("codeUser")

            loadRoutes(codeUser)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //showDetailRoute
    fun showDetail(route: RoutesDTO) {
        try {
            val intent = Intent(this, DetailedRoutesActivity::class.java)
            intent.putExtra("route", route)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //loadRoutes
    private fun loadRoutes(codeUser: String?) {
        try {
            listView = findViewById(R.id.listRoutes)
            routesView.routesModel(codeUser, this) {
                if (it!!.listRoutes != null && it.listRoutes!!.isNotEmpty()) {
                    val adapter = RouteAdapter(this, it.listRoutes as ArrayList<RoutesDTO>)
                    listView.adapter = adapter
                } else {
                    //errors
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    //endregion
}