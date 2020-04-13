package com.android.ksih_covid_19_app.utility

/**
 * Created by SegunFrancis
 */
class Result<out T>(
    val status: State,
    val message: String? = null,
    val data: T? = null,
    val error: Throwable? = null,
    val isRefreshing: Boolean? = null
)