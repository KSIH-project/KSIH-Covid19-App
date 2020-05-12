package com.ksih.ksih_covid_19_app.ui.summary

import androidx.lifecycle.MutableLiveData
import com.ksih.ksih_covid_19_app.dataSource.Repository
import com.ksih.ksih_covid_19_app.model.Country

class MainSummaryViewModel : SummaryViewModel() {

    val summaryList = MutableLiveData<List<Country>>()

    fun fetchSummaryList(){
        dataLoading.value = true
       Repository.getInstance().getSummaryList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                summaryList.value = response?.Countries
            }else {
                empty.value = true
            }
        }
    }

}