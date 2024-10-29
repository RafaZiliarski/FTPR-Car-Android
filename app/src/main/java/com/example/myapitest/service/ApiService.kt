package com.example.myapitest.service

import com.example.myapitest.model.Car
import com.example.myapitest.model.CarValue
import com.example.myapitest.model.EspecificCar
import retrofit2.Call
//import com.example.myapitest.model.CarValue
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("car")
    suspend fun getCars(): List<Car>

    @DELETE("car/{id}")
    suspend fun deleteItem(@Path("id") id: String) : Car

    @POST("car")
    suspend fun addCar(@Body car: Car): Car

    @GET("car/{id}")
    suspend fun getCar(@Path("id") id: String): EspecificCar

    @PATCH("car/{id}")
    suspend fun updateItem(@Path("id") id: String, @Body car: CarValue): EspecificCar

}