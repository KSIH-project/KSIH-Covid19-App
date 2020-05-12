package com.ksih.ksih_covid_19_app.ui.summary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class SummaryViewModel : ViewModel() {

    val empty = MutableLiveData<Boolean>().apply { value = false }
    val  dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val toastMessage = MutableLiveData<String>()


}
