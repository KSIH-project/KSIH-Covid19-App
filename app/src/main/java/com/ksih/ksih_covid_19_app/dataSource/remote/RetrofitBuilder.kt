package com.ksih.ksih_covid_19_app.dataSource.remote

import com.ksih.ksih_covid_19_app.utility.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val covid19Api: Covid19Api = retrofit.create(Covid19Api::class.java)
}


