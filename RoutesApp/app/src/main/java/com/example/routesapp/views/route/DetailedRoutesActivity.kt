package com.example.routesapp.views.route

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.routesapp.R
import com.example.routesapp.data.dto.response.RoutesDTO
import com.example.routesapp.views.PhotoBasicActivity
import kotlinx.android.synthetic.main.activity_detailed_routes.*

class DetailedRoutesActivity : AppCompatActivity() {

    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_routes)
        loadExtras()
    }
    //endregion

    //region Methods

    //loadExtras
    @SuppressLint("SetTextI18n")
    private fun loadExtras() {
        try {
            val route: RoutesDTO? = intent.getParcelableExtra("route")
            txt_detailedruta.text = "${getString(R.string.txt_detailedruta)} ${route!!.idRoute}"
            txt_detailedpoliza.text = "${getString(R.string.txt_detailedpoliza)} ${route.policyAccount}"
            txt_detailedtipovisita.text = "${getString(R.string.txt_detailedtipovisita)} ${route.visitType}"
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //To_Ph_Basic
    fun To_Ph_Basic(view: View?) {
        val next = Intent(this, PhotoBasicActivity::class.java)
        startActivity(next)
    }
    //endregion


}