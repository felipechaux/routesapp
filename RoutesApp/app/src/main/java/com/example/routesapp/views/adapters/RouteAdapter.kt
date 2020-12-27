package com.example.routesapp.views.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.routesapp.R
import com.example.routesapp.data.dto.response.RoutesDTO
import com.example.routesapp.views.AllRoutesActivity
import java.util.*

class RouteAdapter(var context: Context, var routeList: List<RoutesDTO>) : BaseAdapter() {

    override fun getCount(): Int {
        return routeList.size
    }

    override fun getItem(p0: Int): Any {
        return routeList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val route: RoutesDTO = routeList[position]

        val rowView =
                (Objects.requireNonNull(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)) as LayoutInflater).inflate(
                        R.layout.item_list_route_result,
                        null
                )
        rowView.findViewById<TextView>(R.id.txtList).text = "RUTA: " +
                "${routeList[position].idRoute}  POLIZA: ${routeList[position].policyAccount} " +
                "DIRECCION: ${routeList[position].address} MEDIDOR: ${routeList[position].measurer} " +
                "TIPO DE VISITA: ${routeList[position].visitType}"

        rowView.findViewById<TextView>(R.id.txtList).setOnClickListener {
            println("ruta : ${route.idRoute}")
            (context as AllRoutesActivity).showDetail(route)
        }
        return rowView
    }

}