package com.android.ksih_covid_19_app.dataSource

import androidx.lifecycle.LiveData
import com.android.ksih_covid_19_app.dataSource.local.Covid19Dao
import com.android.ksih_covid_19_app.dataSource.local.LocalRepo
import com.android.ksih_covid_19_app.dataSource.remote.Covid19Api
import com.android.ksih_covid_19_app.dataSource.remote.RemoteRepo
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatus
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem
import retrofit2.Call

class BaseRepository(private val api: Covid19Api, private val dao: Covid19Dao): RemoteRepo, LocalRepo {
    override fun getLiveByCountryAndStatusRemote(country: String): Call<List<LiveByCountryAndStatusItem?>> {
        return api.getLiveByCountryAndStatus(country)
    }

    override fun getLiveByCountryAndStatusLocal(country: String): LiveData<List<LiveByCountryAndStatusItem?>> {
        return dao.getLiveByCountryAndStatus()
    }

    override suspend fun setLiveByCountryAndStatusLocal(responseList: List<LiveByCountryAndStatusItem?>) {
        dao.setLiveByCountryAndStatus(responseList)
    }
}