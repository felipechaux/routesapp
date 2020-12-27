package com.example.routesapp.views.route

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import com.example.routesapp.data.dto.request.RequestLoginDTO
import com.example.routesapp.data.dto.response.ResponseLoginDTO
import com.example.routesapp.data.dto.response.ResponseRoutesDTO
import com.example.routesapp.data.repositories.LoginRepository
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