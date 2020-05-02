package com.android.ksih_covid_19_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Global(
    @PrimaryKey
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)