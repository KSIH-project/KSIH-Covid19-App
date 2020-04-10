package com.android.ksih_covid_19_app.ui.summary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.ksih_covid_19_app.model.Summary

open class SummaryViewModel : ViewModel() {

    val empty = MutableLiveData<Boolean>().apply { value = false }
    val  dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val toastMessage = MutableLiveData<String>()


}
