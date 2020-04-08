package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus

import android.app.Application
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatus
import com.android.ksih_covid_19_app.viewModel.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveByCountryAndStatusViewModel(myApplication: Application) : BaseViewModel(myApplication){
    private val model: BaseViewModel = BaseViewModel(myApplication)

    fun getLiveByCountryRemote(country: String) {
        model.getLiveByCountryAndStatusRemote(country).enqueue(object : Callback<LiveByCountryAndStatus?> {
            override fun onResponse(
                call: Call<LiveByCountryAndStatus?>,
                response: Response<LiveByCountryAndStatus?>
            ) {
                model.setLiveByCountryAndStatus(response.body()!!.list)
            }

            override fun onFailure(call: Call<LiveByCountryAndStatus?>, t: Throwable) {

            }
        })
    }
}
