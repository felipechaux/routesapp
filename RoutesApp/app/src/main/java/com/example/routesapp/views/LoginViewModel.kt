package com.example.routesapp.views

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import com.example.routesapp.data.dto.request.RequestLoginDTO
import com.example.routesapp.data.dto.response.ResponseLoginDTO
import com.example.routesapp.data.repositories.LoginRepository

class LoginViewModel : ViewModel() {

    private var loginRepository: LoginRepository? = null

    init {
        loginRepository = LoginRepository()
    }

    fun loginModel(
            requestLoginDTO: RequestLoginDTO, context: Context,
            onResult: (ResponseLoginDTO?) -> Unit
    ) {
        loginRepository?.loginRepository(requestLoginDTO) {
            onResult(it)
        }
    }




}