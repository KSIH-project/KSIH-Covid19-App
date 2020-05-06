package com.android.ksih_covid_19_app.ui.symptoms

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.ksih_covid_19_app.dataSource.BaseRepository
import com.android.ksih_covid_19_app.dataSource.local.Covid19Dao
import com.android.ksih_covid_19_app.dataSource.local.Covid19RoomDatabase
import com.android.ksih_covid_19_app.dataSource.remote.RetrofitBuilder.covid19Api
import com.android.ksih_covid_19_app.model.Global
import com.android.ksih_covid_19_app.model.Summary
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreventionViewModel(application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val repository:BaseRepository
    private val dao: Covid19Dao = Covid19RoomDatabase.getDatabase(application).covid19Dao()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
     val global = MutableLiveData<Global>()
    init {
        repository = BaseRepository(covid19Api,dao)
        getSummaryRemote()
}

    private fun getSummaryRemote() {
        repository.getSummary().enqueue(object :Callback<Summary>{
            override fun onFailure(call: Call<Summary>, t: Throwable) {
               Log.d("Prevention" , "On failure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<Summary>, response: Response<Summary>) {
                Log.d("Prevention" , "On success: ${response.code()}")

                uiScope.launch {
                    withContext(Dispatchers.IO){
                        Log.d("database" , "On database write: ${response.body()?.Global?.TotalConfirmed}")

                        repository.setGlobalList(response.body()!!.Global)

                        Log.d("database" , "On failure: ${repository.getGlobalCases().value}")

                    }
                }
            }
        })
    }
     fun getData(): LiveData<Global> {
        getSummaryRemote()
        return repository.getGlobalCases()

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }




}