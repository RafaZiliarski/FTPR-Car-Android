package com.example.myapitest.model

data class Car(
    val id: String,
    val imageUrl: String,
    val year: String,
    val name: String,
    val licence: String,
    val place: CarPlace?
)

data class CarPlace(
    val name: String,
    val lat: Double,
    val long: Double
)