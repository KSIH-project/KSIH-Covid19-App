package com.android.ksih_covid_19_app.utility

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.covid19api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        val covid19Api = retrofit.create(Covid19Api::class.java)
}


