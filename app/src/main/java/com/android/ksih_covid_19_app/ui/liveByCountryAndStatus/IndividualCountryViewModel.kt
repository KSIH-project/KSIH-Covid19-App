package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatus
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem
import com.android.ksih_covid_19_app.utility.Result
import com.android.ksih_covid_19_app.utility.State
import com.android.ksih_covid_19_app.viewModel.BaseViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by SegunFrancis
 */
class IndividualCountryViewModel(myApplication: Application): BaseViewModel(myApplication) {
    private val model: BaseViewModel = BaseViewModel(myApplication)
    var responseMessage = MutableLiveData<Result<LiveByCountryAndStatus>>()

    fun getLiveByCountryRemote(country: String) {
        responseMessage.postValue(
            Result(
                status = State.LOADING,
                message = "Loading..."
            )
        )
        model.getLiveByCountryAndStatusRemote(country)
            .enqueue(object : Callback<List<LiveByCountryAndStatusItem?>> {
                override fun onResponse(
                    call: Call<List<LiveByCountryAndStatusItem?>>,
                    response: Response<List<LiveByCountryAndStatusItem?>>
                ) {
                    responseMessage.postValue(
                        Result(
                            status = State.SUCCESS,
                            message = "Success"
                        )
                    )
                    viewModelScope.launch {
                        model.setLiveByCountryAndStatus(response.body()!!)
                    }
                    Log.d("LiveByCountryViewModel", response.body().toString())
                }

                override fun onFailure(call: Call<List<LiveByCountryAndStatusItem?>>, t: Throwable) {
                    responseMessage.postValue(
                        Result(
                            status = State.ERROR,
                            message = "Check Internet Connection",
                            error = t
                        )
                    )
                    Log.e("IndividualCountryModel", t.localizedMessage!!)
                }
            })
    }

    fun getLiveByCountryLocal(country: String): LiveData<List<LiveByCountryAndStatusItem?>> {
        return model.getLiveByCountryAndStatusLocal(country)
    }
}