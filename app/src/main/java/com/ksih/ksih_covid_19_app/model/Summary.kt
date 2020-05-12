package com.ksih.ksih_covid_19_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Summary(
    @PrimaryKey
    val Countries: List<Country>,
    val Date: String,
    val Global: Global
)