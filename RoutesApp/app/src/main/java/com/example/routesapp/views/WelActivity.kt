package com.example.routesapp.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.routesapp.R
import com.example.routesapp.data.dto.response.ResponseLoginDTO
import kotlinx.android.synthetic.main.activity_wel.*

class WelActivity : AppCompatActivity() {

    private var user: ResponseLoginDTO?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wel)

        loadExtras()

    }

    @SuppressLint("SetTextI18n")
    private fun loadExtras() {
        try {
            user= intent.getParcelableExtra("user")
            txtWelcome.text = "${getString(R.string.txtv_welcome)} ${user!!.userNameDescription}"

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun Regresar(view: View?) {
        val regresar = Intent(this, LoginActivity::class.java)
        startActivity(regresar)
    }

    fun Consultar(view: View?) {
        Toast.makeText(this, "Consultando Rutas...", Toast.LENGTH_SHORT).show()
        val next = Intent(this, AllRoutesActivity::class.java)
        next.putExtra("codeUser", user?.userCode)
        startActivity(next)
    }
}