package com.android.ksih_covid_19_app.ui.symptoms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.ksih_covid_19_app.dataSource.BaseRepository
import com.android.ksih_covid_19_app.dataSource.local.Covid19Dao
import com.android.ksih_covid_19_app.dataSource.local.Covid19RoomDatabase
import com.android.ksih_covid_19_app.dataSource.remote.RetrofitBuilder.covid19Api
import com.android.ksih_covid_19_app.model.Global
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class PreventionViewModel(val database: Covid19Dao, application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val repository:BaseRepository
    private val dao: Covid19Dao = Covid19RoomDatabase.getDatabase(application).covid19Dao()
    var reselt = MutableLiveData<Global>()
    init {
        repository = BaseRepository(covid19Api,dao)
        getSummaryRemote()
    }

    private fun getSummaryRemote() {
        TODO("Not yet implemented")
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
            private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

}