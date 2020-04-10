package com.android.ksih_covid_19_app.dataSource

import com.android.ksih_covid_19_app.dataSource.remote.ApiClient
import com.android.ksih_covid_19_app.model.Summary
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseRepository {

    //for summary
    fun getSummaryList(onResult: (isSuccess: Boolean, response: Summary?) -> Unit){

        ApiClient.instance.getSummary().enqueue(object : Callback<Summary> {
            override fun onResponse(call: Call<Summary>, response: Response<Summary>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Summary>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}