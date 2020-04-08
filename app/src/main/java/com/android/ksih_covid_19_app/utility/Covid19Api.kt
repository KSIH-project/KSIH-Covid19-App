package com.android.ksih_covid_19_app.utility

import com.android.ksih_covid_19_app.Model.Country
import com.android.ksih_covid_19_app.Model.CountrySummary
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Covid19Api {

    @GET("/country/{country}/status/confirmed")
    fun getByCountryAndStatus(): Call<List<Country>>

    @GET("/summary")
    fun getSummary(): Call<List<CountrySummary>>
}