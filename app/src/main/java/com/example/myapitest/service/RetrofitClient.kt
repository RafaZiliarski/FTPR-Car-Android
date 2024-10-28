package com.example.myapitest.service

import com.example.myapitest.database.DatabaseBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    //private const val BASE_URL = "http://10.0.2.2:3000/"/*IP Local do computador para executar
    //        pelo emulador */
    private const val BASE_URL = "http://192.168.0.7:3000/" /*IP Local do computador para executar
        pelo celular */
    private val logginInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient= OkHttpClient.Builder()
        .addInterceptor(logginInterceptor)
        .addInterceptor(
            GeoLocationInterceptor(
                DatabaseBuilder.getInstance().userLocationDao()
            )
        )
        .build()

    private val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService = instance.create(ApiService::class.java)

}