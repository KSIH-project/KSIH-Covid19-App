package com.android.ksih_covid_19_app.ui.dayOneTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.android.ksih_covid_19_app.R
import kotlinx.android.synthetic.main.home_fragment.*

class DayOneTotalFragment : Fragment() {

    private val viewModel: DayOneTotalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Remove temporary navigation
        home_text.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.liveByCountryAndStatusFragment)
        }
    }
}
