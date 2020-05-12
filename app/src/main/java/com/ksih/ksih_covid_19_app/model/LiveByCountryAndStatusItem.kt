package com.ksih.ksih_covid_19_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LiveByCountryAndStatusItem(
    @PrimaryKey
    val Active: Int,
    val Confirmed: Int,
    val Country: String,
    val CountryCode: String,
    val Date: String,
    val Deaths: Int,
    val Lat: String,
    val LocationID: String,
    val Lon: String,
    val Recovered: Int
)