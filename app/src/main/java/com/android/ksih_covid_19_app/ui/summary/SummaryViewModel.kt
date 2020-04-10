package com.android.ksih_covid_19_app.ui.summary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.ksih_covid_19_app.model.Summary

class SummaryViewModel : ViewModel() {

    lateinit var summaryList: MutableLiveData<Summary>


}
