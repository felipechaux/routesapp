package com.example.routesapp.data.repositories


import com.example.routesapp.data.dto.request.RequestLoginDTO
import com.example.routesapp.data.dto.response.ResponseLoginDTO
import com.example.routesapp.data.dto.response.ResponseRoutesDTO
import com.example.routesapp.services.ApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * **************************************************************************
 * NAME: LoginRepository.kt
 * DESCRIPTION:  Ejemplo de repositorio, hace el llamado directo a un servicio.

 */

class RouteRepository {


    fun getRoutesRepository(userData: String?, onResult: (ResponseRoutesDTO?) -> Unit) {
        ApiFactory.build()?.getRoutes(userData)?.enqueue(
                object : Callback<ResponseRoutesDTO> {

                    override fun onFailure(call: Call<ResponseRoutesDTO>, t: Throwable) {
                        onResult(null)
                    }

                    override fun onResponse(
                            call: Call<ResponseRoutesDTO>,
                            response: Response<ResponseRoutesDTO>
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
