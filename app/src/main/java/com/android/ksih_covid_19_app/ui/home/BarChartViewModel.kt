package com.android.ksih_covid_19_app.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.android.ksih_covid_19_app.dataSource.BaseRepository
import com.android.ksih_covid_19_app.dataSource.local.Covid19Dao
import com.android.ksih_covid_19_app.dataSource.local.Covid19RoomDatabase
import com.android.ksih_covid_19_app.dataSource.remote.RetrofitBuilder
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.model.Global
import com.android.ksih_covid_19_app.model.Summary
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BarChartViewModel(application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val repository: BaseRepository
    private val dao: Covid19Dao = Covid19RoomDatabase.getDatabase(application).covid19Dao()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val global: LiveData<Global>
    val countries : LiveData<List<Country>>
    init {
        repository = BaseRepository(RetrofitBuilder.covid19Api,dao)
        getSummaryRemote()
        global = repository.getGlobalCases()
        countries = repository.getCountryAndNewCasesList()

    }
    private fun getSummaryRemote() {
        repository.getSummary().enqueue(object : Callback<Summary> {
            override fun onFailure(call: Call<Summary>, t: Throwable) {
                Log.d("Prevention" , "On failure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<Summary>, response: Response<Summary>) {
                uiScope.launch {
                    withContext(Dispatchers.IO){
                        response.body()?.Global?.let { repository.setGlobalList(it) }
                        response.body()?.Countries?.let {
                            repository.setCountryAndNewCasesListLocal(
                                it
                            )
                        }
                    }
                }
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
