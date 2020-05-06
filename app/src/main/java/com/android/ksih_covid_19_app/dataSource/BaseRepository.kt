package com.android.ksih_covid_19_app.dataSource

import androidx.lifecycle.LiveData
import com.android.ksih_covid_19_app.dataSource.local.Covid19Dao
import com.android.ksih_covid_19_app.dataSource.local.LocalRepo
import com.android.ksih_covid_19_app.dataSource.remote.Covid19Api
import com.android.ksih_covid_19_app.dataSource.remote.RemoteRepo
import com.android.ksih_covid_19_app.model.*
import retrofit2.Call

class BaseRepository(private val api: Covid19Api, private val dao: Covid19Dao) : RemoteRepo,
        LocalRepo {
        override fun getLiveByCountryAndStatusRemote(country: String): Call<List<LiveByCountryAndStatusItem?>> {
            return api.getLiveByCountryAndStatus(country)
        }

    override fun getLiveByCountryAndStatusLocal(country: String): LiveData<List<LiveByCountryAndStatusItem?>> {
        return dao.getLiveByCountryAndStatus()
    }

    override suspend fun setLiveByCountryAndStatusLocal(responseList: List<LiveByCountryAndStatusItem?>) {
        dao.setLiveByCountryAndStatus(responseList)
    }
         override suspend fun setGlobalList(globalCases: Global) {
            dao.setGlobalList(globalCases)
        }

    override fun getCountryAndNewCasesList(): LiveData<List<Country>> {
       return dao.getCountryAndNewCasesList()
    }

    override fun getGlobalCases(): LiveData<Global> {
           return dao.getGlobalList()
        }


        override fun getSearchAllCountries(query: String?): LiveData<List<Country>> {
        return dao.getSearchAllCountries("%$query%")
    }

    override suspend fun setCountryAndNewCasesListLocal(countryList: List<Country>) {
        dao.setCountryAndNewCasesList(countryList)
    }



        override fun getSummary(): Call<Summary> {
        return api.getSummary()
    }

    override fun getDayOneTotal(country: String): Call<List<DayOneTotalResponseItem>> {
        return api.getDayOneTotal(country)
    }

    override fun getSearchByDate(
        country: String,
        status: String,
        date: String
    ): Call<List<SearchByDateItem>> {
        return api.getSearchByDate(country, status, date)
    }


}