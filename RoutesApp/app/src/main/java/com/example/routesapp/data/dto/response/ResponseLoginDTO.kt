package com.example.routesapp.data.dto.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ResponseLoginDTO():Parcelable {

    @SerializedName("Response")
    var response: String?=null
    @SerializedName("UserNameDescription")
    var userNameDescription: String?=null

    var userCode: String?=null

    constructor(parcel: Parcel) : this() {
        response = parcel.readString()
        userNameDescription = parcel.readString()
        userCode = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(response)
        parcel.writeString(userNameDescription)
        parcel.writeString(userCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResponseLoginDTO> {
        override fun createFromParcel(parcel: Parcel): ResponseLoginDTO {
            return ResponseLoginDTO(parcel)
        }

        override fun newArray(size: Int): Array<ResponseLoginDTO?> {
            return arrayOfNulls(size)
        }
    }


}