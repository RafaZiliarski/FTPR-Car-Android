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

    @GET("car")
    suspend fun getCars(): List<Car>

    @GET("car/{id}")
    suspend fun getItem(@Path("id") id: String) : Car

    @DELETE("car/{id}")
    suspend fun deleteItem(@Path("id") id: String) : Car

    @POST("car")
    suspend fun addItem(@Body car: CarValue): Car

    @PATCH("car/{id}")
    suspend fun updateItem(@Path("id") id: String, @Body car: CarValue): Car

}