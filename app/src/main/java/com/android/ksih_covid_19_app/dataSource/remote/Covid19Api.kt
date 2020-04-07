package com.android.ksih_covid_19_app.dataSource.remote

import com.android.ksih_covid_19_app.model.DayOneTotalResponse
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatus
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Covid19Api {
    @GET("live/country/{country}/status/confirmed")
    fun getLiveByCountryAndStatus(country: String): Call<LiveByCountryAndStatus>

    @GET("total/dayone/country/{country}/status/confirmed")
    fun getDayOneTotal(country: String): Call<DayOneTotalResponse>
}