package com.ksih.ksih_covid_19_app.dataSource.remote

import com.ksih.ksih_covid_19_app.model.DayOneTotalResponseItem
import com.ksih.ksih_covid_19_app.model.LiveByCountryAndStatusItem
import com.ksih.ksih_covid_19_app.model.SearchByDateItem
import com.ksih.ksih_covid_19_app.model.Summary
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

    @GET("live/country/{country}/status/{status}/date/{date}")
    fun getSearchByDate(@Path("country") country: String,@Path ("status") status:String,
                        @Path("date") date:String): Call<List<SearchByDateItem>>
}
