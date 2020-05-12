package com.ksih.ksih_covid_19_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DayOneTotalResponseItem(
    @PrimaryKey
    val Cases: Int,
    val Country: String,
    val CountryCode: String,
    val Date: String,
    val Lat: String,
    val Lon: String,
    val Status: String
)