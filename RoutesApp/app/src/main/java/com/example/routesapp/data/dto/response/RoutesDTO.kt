package com.example.routesapp.data.dto.response

import com.google.gson.annotations.SerializedName

class RoutesDTO {

    @SerializedName("IdRuta")
    var idRoute: Long? = 0

    @SerializedName("TipoProyecto")
    var projectType: String? = null

    @SerializedName("Division")
    var division: String? = null

    @SerializedName("CuentaPoliza")
    var policyAccount: String? = null

    @SerializedName("Direccion")
    var address: String? = null

    @SerializedName("Municipio")
    var municipality: String? = null

    @SerializedName("Medidor")
    var measurer: String? = null

    @SerializedName("TipoVisita")
    var visitType: String? = null

    @SerializedName("CodInspector")
    var codInspector: String? = null

    @SerializedName("NombreInspector")
    var inspectorName: String? = null

    @SerializedName("FechaVisita")
    var visitDate: String? = null

    @SerializedName("Estado")
    var state: Any? = null

    @SerializedName("Resultado")
    var result: Any? = null

    @SerializedName("FechaCarga")
    var carrierDate: String? = null

    @SerializedName("UsuarioCarga")
    var carrierUser: Any? = null


}