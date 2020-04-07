package com.android.ksih_covid_19_app.dataSource.remote

import com.android.ksih_covid_19_app.model.DayOneTotalResponse
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatus
import com.android.ksih_covid_19_app.model.Summary
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Covid19Api {
    @GET("live/country/{country}/status/confirmed")
    fun getLiveByCountryAndStatus(@Path("country") country: String): Call<LiveByCountryAndStatus>

    @GET("total/dayone/country/{country}/status/confirmed")
    fun getDayOneTotal(@Path("country") country: String): Call<DayOneTotalResponse>

    @GET("summary")
    fun getSummary(): Call<Summary>
}
