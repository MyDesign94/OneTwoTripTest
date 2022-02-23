package com.example.onetwotriptest.data.remote.dto

data class Flights(
    val currency: String,
    val prices: List<Price>,
    val trips: List<Trip>
)