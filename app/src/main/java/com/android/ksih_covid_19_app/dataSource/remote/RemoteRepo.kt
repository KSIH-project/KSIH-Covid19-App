package com.android.ksih_covid_19_app.dataSource.remote

import com.android.ksih_covid_19_app.model.LiveByCountryAndStatus
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem
import retrofit2.Call

/**
 * Created by SegunFrancis
 */
interface RemoteRepo {

    fun getLiveByCountryAndStatusRemote(country: String): Call<List<LiveByCountryAndStatusItem?>>

}