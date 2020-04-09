package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.model.Summary
import com.android.ksih_covid_19_app.utility.Result
import com.android.ksih_covid_19_app.utility.State
import com.android.ksih_covid_19_app.viewModel.BaseViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveByCountryAndStatusViewModel(myApplication: Application) : BaseViewModel(myApplication) {
    private val model: BaseViewModel = BaseViewModel(myApplication)
    var responseMessage = MutableLiveData<Result<Summary>>()

    fun getSummaryRemote() {
        responseMessage.postValue(Result(State.LOADING, message = "Loading..."))
        model.getSummary().enqueue(object : Callback<Summary?> {
            override fun onResponse(call: Call<Summary?>, response: Response<Summary?>) {
                viewModelScope.launch {
                    model.setCountryAndNewCasesList(response.body()!!.Countries)
                }
                responseMessage.postValue(Result(State.SUCCESS, message = "Success"))
            }

            override fun onFailure(call: Call<Summary?>, t: Throwable) {
                responseMessage.postValue(
                    Result(
                        State.ERROR,
                        message = "Check Network Connection",
                        error = t
                    )
                )
                Log.e("LiveByCountryViewModel", t.localizedMessage!!)
            }
        })
    }

    fun getCountryAndNewCasesList(): LiveData<List<Country>> {
        return model.getCountryAndNewCasesListLocal()
    }
}
