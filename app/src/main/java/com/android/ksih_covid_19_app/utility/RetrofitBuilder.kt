package com.android.ksih_covid_19_app.utility

import retrofit2.Retrofit

class RetrofitBuilder {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.covid19api.com/").build()


}