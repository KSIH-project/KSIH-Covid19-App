package com.android.ksih_covid_19_app.dataSource.remote

import com.android.ksih_covid_19_app.model.DayOneTotalResponseItem
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem
import com.android.ksih_covid_19_app.model.Summary
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Covid19Api {
    @GET("live/country/{country}/status/confirmed")
    fun getLiveByCountryAndStatus(@Path("country") country: String): Call<List<LiveByCountryAndStatusItem?>>

    @GET("total/dayone/country/{country}/status/confirmed")
    fun getDayOneTotal(@Path("country") country: String): Call<List<DayOneTotalResponseItem>>

    @GET("summary")
    fun getSummary(): Call<Summary>

    @GET("live/country/{country}/status/{country}/date/")
}
