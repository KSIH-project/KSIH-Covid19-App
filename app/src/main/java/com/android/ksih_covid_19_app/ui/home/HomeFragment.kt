package com.android.ksih_covid_19_app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController

import com.android.ksih_covid_19_app.R
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Todo: Remove temporary navigation
        button_total_cases.setOnClickListener {
            findNavController(it).navigate(R.id.countryFragment)
        }
        button_live_cases.setOnClickListener {
            findNavController(it).navigate(R.id.liveByCountryAndStatusFragment)
        }
    }
}
