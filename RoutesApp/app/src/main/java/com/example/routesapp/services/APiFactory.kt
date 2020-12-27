package com.example.routesapp.services

import com.example.routesapp.utils.ConstantApp
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * **************************************************************************
 * NAME: APIFactory.kt
 * DESCRIPTION:  Clase usada para realizar el llamado de los servicios por medio de la librería retrofit .
***************************************************************************
 */
class ApiFactory {

    // Inicialización del api factory
    init {
        setup()
    }

    companion object {


        // Timeout usado por defecto al momento de llamar los servicios
        private val defaultTimeOut: Long = ConstantApp.TIMEOUT_SERVICES

        // URL con la cual se llama a los servicios
        private val BASE_URL = ConstantApp.BASE_URL
        private var retrofit: Retrofit.Builder? = null

        /**
         * Método público usado para llamar la configuración de la api
         */
        fun build(timeOut: Long = defaultTimeOut): RoutesService? {
            return setup(timeOut)
                ?.build()?.create(RoutesService::class.java)
        }


        /**
         * Método privado usado para retornar la librería de retrofit ya configurada con los parámetros necesarios
         * para realizar el llamado de los servicios
         */
        private fun setup(timeOut: Long = defaultTimeOut): Retrofit.Builder? {
            retrofit = Retrofit.Builder()

            val lenient = GsonBuilder().setLenient().create()
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val clientBuilder = OkHttpClient.Builder()
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .addInterceptor(logging)


            retrofit?.client(clientBuilder.build())
                ?.baseUrl(BASE_URL)
                ?.addConverterFactory(GsonConverterFactory.create(lenient))
                ?.addCallAdapterFactory(RxJava2CallAdapterFactory.create())

            return retrofit
        }
    }
}