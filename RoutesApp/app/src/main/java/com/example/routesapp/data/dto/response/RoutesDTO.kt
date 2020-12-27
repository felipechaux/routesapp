package com.example.routesapp.data.dto.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class RoutesDTO() : Parcelable{

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

    constructor(parcel: Parcel) : this() {
        idRoute = parcel.readValue(Long::class.java.classLoader) as? Long
        projectType = parcel.readString()
        division = parcel.readString()
        policyAccount = parcel.readString()
        address = parcel.readString()
        municipality = parcel.readString()
        measurer = parcel.readString()
        visitType = parcel.readString()
        codInspector = parcel.readString()
        inspectorName = parcel.readString()
        visitDate = parcel.readString()
        carrierDate = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idRoute)
        parcel.writeString(projectType)
        parcel.writeString(division)
        parcel.writeString(policyAccount)
        parcel.writeString(address)
        parcel.writeString(municipality)
        parcel.writeString(measurer)
        parcel.writeString(visitType)
        parcel.writeString(codInspector)
        parcel.writeString(inspectorName)
        parcel.writeString(visitDate)
        parcel.writeString(carrierDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoutesDTO> {
        override fun createFromParcel(parcel: Parcel): RoutesDTO {
            return RoutesDTO(parcel)
        }

        override fun newArray(size: Int): Array<RoutesDTO?> {
            return arrayOfNulls(size)
        }
    }


}