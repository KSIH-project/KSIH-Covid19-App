package com.android.ksih_covid_19_app.dataSource.remote

import com.android.ksih_covid_19_app.model.DayOneTotalResponseItem
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem
import com.android.ksih_covid_19_app.model.SearchByDateItem
import com.android.ksih_covid_19_app.model.Summary
import retrofit2.Call

/**
 * Created by SegunFrancis
 */
interface RemoteRepo {

    fun getLiveByCountryAndStatusRemote(country: String): Call<List<LiveByCountryAndStatusItem?>>

    fun getSummary(): Call<Summary>

    fun getDayOneTotal(country: String): Call<List<DayOneTotalResponseItem>>

    fun getSearchByDate(country: String, status:String, date:String): Call<List<SearchByDateItem>>

}