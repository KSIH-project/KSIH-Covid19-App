package com.android.ksih_covid_19_app.dataSource

import com.android.ksih_covid_19_app.dataSource.remote.ApiClient
import com.android.ksih_covid_19_app.model.Summary
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    //for summary
    fun getSummaryList(onResult: (isSuccess: Boolean, response: Summary?) -> Unit) {

        ApiClient.instance.getSummary().enqueue(object : Callback<Summary> {
            override fun onResponse(call: Call<Summary>, response: Response<Summary>) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body())
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<Summary>, t: Throwable) {
                onResult(false, null)
            }
        })
    }

    companion object {
        private var INSTANCE: Repository? = null
        fun getInstance() = INSTANCE
            ?: Repository().also { it ->
                INSTANCE = it
            }
    }

}