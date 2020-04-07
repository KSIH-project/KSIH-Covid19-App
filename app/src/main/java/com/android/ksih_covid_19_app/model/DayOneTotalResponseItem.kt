package com.android.ksih_covid_19_app.model

data class DayOneTotalResponseItem(
    val Cases: Int,
    val Country: String,
    val CountryCode: String,
    val Date: String,
    val Lat: String,
    val Lon: String,
    val Status: String
)