package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.android.ksih_covid_19_app.dataSource.BaseRepository
import com.android.ksih_covid_19_app.dataSource.local.Covid19Dao
import com.android.ksih_covid_19_app.dataSource.local.Covid19RoomDatabase
import com.android.ksih_covid_19_app.dataSource.remote.RetrofitBuilder.covid19Api
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.model.Summary
import com.android.ksih_covid_19_app.utility.CountryMediatorLiveData
import com.android.ksih_covid_19_app.utility.Event
import com.android.ksih_covid_19_app.utility.Result
import com.android.ksih_covid_19_app.utility.State
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveByCountryAndStatusViewModel(myApplication: Application) :
    AndroidViewModel(myApplication) {
    private val repository: BaseRepository
    private val dao: Covid19Dao = Covid19RoomDatabase.getDatabase(myApplication).covid19Dao()
    private val _searchQuery = MutableLiveData("")
    private val countries: LiveData<List<Country>>
    var responseMessage = MutableLiveData<Event<Result<Summary>>>()

    init {
        repository = BaseRepository(covid19Api, dao)
        getSummaryRemote()

        countries = Transformations.switchMap(CountryMediatorLiveData(_searchQuery)) {
            repository.getSearchAllCountries(it)
        }
    }

    fun getCountriesFromLocal(): LiveData<List<Country>> {
        return countries
    }

    private fun getSummaryRemote() {
        responseMessage.postValue(
            Event(
                Result(
                    State.LOADING,
                    message = "Loading...",
                    isRefreshing = true
                )
            )
        )
        repository.getSummary().enqueue(object : Callback<Summary?> {
            override fun onResponse(call: Call<Summary?>, response: Response<Summary?>) {
                viewModelScope.launch {
                    repository.setCountryAndNewCasesListLocal(response.body()?.Countries)
                }
                responseMessage.postValue(
                    Event(
                        Result(
                            State.SUCCESS,
                            message = "Success",
                            isRefreshing = false
                        )
                    )
                )
                Log.d("LiveByViewModel", "Loaded")
            }

            override fun onFailure(call: Call<Summary?>, t: Throwable) {
                responseMessage.postValue(
                    Event(
                        Result(
                            State.ERROR,
                            message = "Check Network Connection",
                            error = t,
                            isRefreshing = false
                        )
                    )
                )
                Log.e("LiveByCountryViewModel", t.localizedMessage!!)
            }
        })
    }

    fun getSearchResults(searchString: String?) {
        _searchQuery.value = searchString
    }

    fun refreshList() {
        getSummaryRemote()
    }
}
