package com.example.myapitest.service

import com.example.myapitest.model.Car
import com.example.myapitest.model.CarValue
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("cars")
    suspend fun getItems(): List<Car>

    @GET("cars/{id}")
    suspend fun getItem(@Path("id") id: String) : Car

    @DELETE("cars/{id}")
    suspend fun deleteItem(@Path("id") id: String) : Car

    @POST("cars")
    suspend fun addItem(@Body car: CarValue): Car

    @PATCH("cars/{id}")
    suspend fun updateItem(@Path("id") id: String, @Body car: CarValue): Car

}