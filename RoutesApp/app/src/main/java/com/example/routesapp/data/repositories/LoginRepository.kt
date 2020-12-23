package com.example.routesapp.data.repositories


import com.example.routesapp.data.dto.request.RequestLoginDTO
import com.example.routesapp.data.dto.response.ResponseLoginDTO
import com.example.routesapp.services.ApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * **************************************************************************
 * NAME: LoginRepository.kt
 * DESCRIPTION:  Ejemplo de repositorio, hace el llamado directo a un servicio.

 */

class LoginRepository {


    fun loginRepository(userData: RequestLoginDTO, onResult: (ResponseLoginDTO?) -> Unit) {
        ApiFactory.build()?.login(userData.username, userData.password)?.enqueue(
                object : Callback<ResponseLoginDTO> {

                    override fun onFailure(call: Call<ResponseLoginDTO>, t: Throwable) {
                        onResult(null)
                    }

                    override fun onResponse(
                            call: Call<ResponseLoginDTO>,
                            response: Response<ResponseLoginDTO>
                    ) {
                        val res = response.body()
                        if (response.code() == 200 && res != null) {
                            onResult(res)
                        } else {
                            onResult(null)
                        }
                    }
                }
        )
    }


}
