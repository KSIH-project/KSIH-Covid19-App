package com.android.ksih_covid_19_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Global(

    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    @PrimaryKey
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)