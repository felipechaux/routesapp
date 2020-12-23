package com.example.routesapp.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.routesapp.R
import com.example.routesapp.data.dto.request.RequestLoginDTO


class LoginActivity : AppCompatActivity() {

    //region Variables
    private lateinit var loginView: LoginViewModel
    var et1: EditText? = null
    var et2: EditText? = null
    var btn_login: Button? = null
    //endregion

    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1 = findViewById<View>(R.id.txt_usuario) as EditText
        et2 = findViewById<View>(R.id.txt_contrasena) as EditText
        btn_login = findViewById<View>(R.id.button_login) as Button

        setupViewModel()

    }
    //endregion

    //region Methods

    private fun setupViewModel() {
        try {
            loginView = ViewModelProvider(this)[LoginViewModel::class.java]
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun authUser() {
        try {
            val requestLoginDTO = RequestLoginDTO().apply {
                this.username = et1!!.text.toString()
                this.password = et2!!.text.toString()
            }
            loginView.loginModel(requestLoginDTO, this) {
                if (it != null && it.response.equals("Ok")) {
                    Toast.makeText(this, "User :  ${it.userNameDescription}", Toast.LENGTH_SHORT).show()
                    val next = Intent(this, WelActivity::class.java)
                    startActivity(next)
                } else {
                    //errors
                    Toast.makeText(this, it!!.response, Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    fun Next(view: View?) {
        val usuario = et1!!.text.toString()
        val contrasena = et2!!.text.toString()
        if (usuario.isEmpty()) {
            Toast.makeText(this, "Se requiere un usuario", Toast.LENGTH_SHORT).show()
        }
        if (contrasena.isEmpty()) {
            Toast.makeText(this, "Se requiere una contraseña", Toast.LENGTH_SHORT).show()
        }
        if (contrasena.isNotEmpty() && usuario.isNotEmpty()) {
            Toast.makeText(this, "Validando información...", Toast.LENGTH_SHORT).show()
            authUser()
        }
    }


    //endregion

}

