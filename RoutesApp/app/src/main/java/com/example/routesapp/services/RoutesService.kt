package com.example.routesapp.services


import com.example.routesapp.data.dto.response.ResponseLoginDTO
import com.example.routesapp.data.dto.response.ResponseRoutesDTO
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

    @GET("Api/WSRuta/ObtenerRutasAsignadas")
    fun getRoutes(@Query("UserName") username: String?): Call<ResponseRoutesDTO>

}