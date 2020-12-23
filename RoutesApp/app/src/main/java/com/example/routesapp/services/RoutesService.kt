package com.example.routesapp.services


import com.example.routesapp.data.dto.response.ResponseLoginDTO
import retrofit2.Call
import retrofit2.http.*


/**
 * **************************************************************************
 * NAME: RoutesService.kt
 * DESCRIPTION:  Clase que contiene los endpoints de los servicios Cliente .
 ***************************************************************************
 */
interface RoutesService {


    @GET("Account/ValidaUsuario")
    fun login(@Query("UserName") username: String?,
              @Query("Password") password: String?): Call<ResponseLoginDTO>


}