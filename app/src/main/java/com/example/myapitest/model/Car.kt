package com.example.myapitest.model

data class Car(
    val id: String,
    val imageUrl: String,
    val year: String,
    val name: String,
    val license: String,
    val place: CarPlace?
    //val value: CarValue
)

/*
data class CarValue(
    val id: String,
    val imageUrl: String,
    val year: String,
    val name: String,
    val licence: String,
    val place: CarPlace?
)
*/

data class CarPlace(
  val name: String,
  val latitude: Double,
val longitude: Double
)