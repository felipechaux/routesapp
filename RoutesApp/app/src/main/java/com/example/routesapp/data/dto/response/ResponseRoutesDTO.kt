package com.example.routesapp.data.dto.response

import com.google.gson.annotations.SerializedName

class ResponseRoutesDTO {

    @SerializedName("ListaRutas")
    var listRoutes: List<RoutesDTO>?=null

}