package com.android.ksih_covid_19_app.dataSource.local

import androidx.lifecycle.LiveData
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem

/**
 * Created by SegunFrancis
 */

interface LocalRepo {

    fun getLiveByCountryAndStatusLocal(country: String): LiveData<List<LiveByCountryAndStatusItem?>>

    suspend fun setLiveByCountryAndStatusLocal(responseList: List<LiveByCountryAndStatusItem?>)
}