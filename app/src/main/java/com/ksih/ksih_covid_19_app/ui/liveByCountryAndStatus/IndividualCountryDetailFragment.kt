package com.ksih.ksih_covid_19_app.ui.liveByCountryAndStatus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ksih.ksih_covid_19_app.R
import com.ksih.ksih_covid_19_app.model.Country
import com.ksih.ksih_covid_19_app.utility.Constants.COUNTRY_BUNDLE_CODE
import com.ksih.ksih_covid_19_app.utility.Constants.toFlagEmoji
import kotlinx.android.synthetic.main.fragment_individual_country_detail.*

/**
 * A simple [Fragment] subclass.
 */
class IndividualCountryDetailFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_individual_country_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val country = requireArguments().getSerializable(COUNTRY_BUNDLE_CODE) as Country
            bottomSheet_confirmed_textView.text = "New Confirmed: ${country.NewConfirmed}"
            bottomSheet_death_textView.text = "New Deaths: ${country.NewDeaths}"
            bottomSheet_date_textView.text =
                "Date: ${country.Date.removeRange(country.Date.indexOf("T") until country.Date.length)}"
            bottomSheet_recovered_textView.text = "New Recovered: ${country.NewRecovered}"
            bottomSheet_country_code_textView.text = country.CountryCode.toFlagEmoji()
        }
    }
}
