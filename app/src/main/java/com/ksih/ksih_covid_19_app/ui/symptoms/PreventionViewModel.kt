package com.ksih.ksih_covid_19_app.ui.symptoms

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ksih.ksih_covid_19_app.dataSource.BaseRepository
import com.ksih.ksih_covid_19_app.dataSource.local.Covid19Dao
import com.ksih.ksih_covid_19_app.dataSource.local.Covid19RoomDatabase
import com.ksih.ksih_covid_19_app.dataSource.remote.RetrofitBuilder.covid19Api
import com.ksih.ksih_covid_19_app.model.Global
import com.ksih.ksih_covid_19_app.model.Summary
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreventionViewModel(application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val repository: BaseRepository
    private val dao: Covid19Dao = Covid19RoomDatabase.getDatabase(application).covid19Dao()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        repository =
           BaseRepository(covid19Api, dao)
        getSummaryRemote()
    }


    private fun getSummaryRemote() {
        repository.getSummary().enqueue(object :Callback<Summary>{
            override fun onFailure(call: Call<Summary>, t: Throwable) {
               Log.d("Prevention" , "On failure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<Summary>, response: Response<Summary>) {
                Log.d("Prevention" , "On success: ${response.code()}")

                if (response.isSuccessful){

                    uiScope.launch {
                        withContext(Dispatchers.IO){
                            repository.setGlobalList(response.body()!!.Global)
                        }
                    }
                }
                }

        })

    }
    fun getGlobal():LiveData<Global>{
        return repository.getGlobalCases()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }




}