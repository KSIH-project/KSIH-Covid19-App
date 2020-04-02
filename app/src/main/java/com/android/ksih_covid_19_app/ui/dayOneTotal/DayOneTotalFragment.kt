package com.android.ksih_covid_19_app.ui.dayOneTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.android.ksih_covid_19_app.R

class DayOneTotalFragment : Fragment() {

    companion object {
        fun newInstance() = DayOneTotalFragment()
    }

    private lateinit var viewModel: DayOneTotalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DayOneTotalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
