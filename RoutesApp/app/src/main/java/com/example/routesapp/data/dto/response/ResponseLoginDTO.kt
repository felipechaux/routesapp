package com.example.routesapp.data.dto.response

import com.google.gson.annotations.SerializedName

class ResponseLoginDTO {

    @SerializedName("Response")
    var response: String?=null
    @SerializedName("UserNameDescription")
    var userNameDescription: String?=null

}