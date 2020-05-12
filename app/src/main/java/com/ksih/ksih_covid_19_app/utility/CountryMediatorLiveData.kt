package com.ksih.ksih_covid_19_app.utility

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 * Created by SegunFrancis
 */
class CountryMediatorLiveData<T>(query: LiveData<T>) : MediatorLiveData<T?>() {
    init {
        addSource(query) {
            value = query.value
        }
    }
}