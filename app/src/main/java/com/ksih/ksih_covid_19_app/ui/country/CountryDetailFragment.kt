package com.ksih.ksih_covid_19_app.ui.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ksih.ksih_covid_19_app.R
import com.ksih.ksih_covid_19_app.model.Country
import com.ksih.ksih_covid_19_app.utility.Constants.COUNTRY_BUNDLE_CODE
import com.ksih.ksih_covid_19_app.utility.Constants.percentageCase
import com.ksih.ksih_covid_19_app.utility.Constants.toFlagEmoji
import kotlinx.android.synthetic.main.fragment_country_detail.*


class CountryDetailFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val country = requireArguments().getSerializable(COUNTRY_BUNDLE_CODE) as Country
            bottomSheet_confirmed_textView.text = "Total Confirmed: ${country.TotalConfirmed}"
            bottomSheet_death_textView.text = "Total Deaths: ${country.TotalDeaths}"
            bottomSheet_date_textView.text =
                "Date: ${country.Date.removeRange(country.Date.indexOf("T") until country.Date.length)}"
            bottomSheet_recovered_textView.text = "Total Recovered: ${country.TotalRecovered}"
            bottomSheet_country_code_textView.text = country.CountryCode.toFlagEmoji()
            textView_percentage_death.text = percentageCase(country.TotalDeaths, country.TotalConfirmed).plus("%")
            textView_percentage_recovered.text = percentageCase(country.TotalRecovered, country.TotalConfirmed).plus("%")
        }
    }
}
