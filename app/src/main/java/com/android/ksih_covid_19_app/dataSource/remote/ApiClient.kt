package com.android.ksih_covid_19_app.dataSource.remote

import com.android.ksih_covid_19_app.utility.Constants.BASE_URL
import com.android.ksih_covid_19_app.utility.Constants.DEBUG
import com.android.ksih_covid_19_app.utility.Constants.REQUEST_TIMEOUT_DURATION
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

    object ApiClient {
        val instance: Covid19Api = Retrofit.Builder().run {
            val gson = GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create()

            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create(gson))
            client(createRequestInterceptorClient())
            build()
        }.create(Covid19Api::class.java)

        private fun createRequestInterceptorClient(): OkHttpClient {
            val interceptor = Interceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                val request = requestBuilder.build()
                chain.proceed(request)
            }

            return if (DEBUG) {
                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .build()
            } else {
                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                    .build()
            }
        }
    }
