package com.example.routesapp.views.route

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.routesapp.data.dto.response.ResponseRoutesDTO
import com.example.routesapp.data.repositories.RouteRepository

class RoutesViewModel : ViewModel() {

    private var routesRepository: RouteRepository? = null

    init {
        routesRepository = RouteRepository()
    }

    fun routesModel(
            requestLoginDTO: String?, context: Context,
            onResult: (ResponseRoutesDTO?) -> Unit
    ) {
        routesRepository?.getRoutesRepository(requestLoginDTO) {
            onResult(it)
        }
    }




}