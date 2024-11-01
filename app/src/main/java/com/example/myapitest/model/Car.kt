package com.example.myapitest.model

data class EspecificCar(
    val id: String,
    val value: Car
)

data class Car(
    val id: String,
    val imageUrl: String,
    val year: String,
    val name: String,
    val licence: String,
    val place: CarPlace?
)

data class CarPlace(
    val lat: Double,
    val long: Double
)