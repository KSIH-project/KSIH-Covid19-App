package com.android.ksih_covid_19_app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.android.ksih_covid_19_app.dataSource.BaseRepository
import com.android.ksih_covid_19_app.dataSource.local.Covid19RoomDatabase
import com.android.ksih_covid_19_app.dataSource.remote.RetrofitBuilder.covid19Api
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatus
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem
import retrofit2.Call

/**
 * Created by SegunFrancis
 */
open class BaseViewModel(myApplication: Application): AndroidViewModel(myApplication) {
    private val repository: BaseRepository
    private val dao = Covid19RoomDatabase.getDatabase(myApplication).covid19Dao()

    init {
        repository = BaseRepository(covid19Api, dao)
    }

    fun getLiveByCountryAndStatusRemote(country: String): Call<List<LiveByCountryAndStatusItem?>> {
        return repository.getLiveByCountryAndStatusRemote(country)
    }

    fun getLiveByCountryAndStatusLocal(country: String): LiveData<List<LiveByCountryAndStatusItem?>> {
        return repository.getLiveByCountryAndStatusLocal(country)
    }

    suspend fun setLiveByCountryAndStatus(responseList: List<LiveByCountryAndStatusItem?>) {
        repository.setLiveByCountryAndStatusLocal(responseList)
    }
}