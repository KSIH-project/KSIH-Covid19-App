package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.utility.State
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.live_by_country_and_status_fragment.*

class LiveByCountryAndStatusFragment : Fragment(R.layout.live_by_country_and_status_fragment) {

    private val viewModel: LiveByCountryAndStatusViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getSummaryRemote()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.responseMessage.observe(viewLifecycleOwner, Observer {
            when(it.status) {
                State.LOADING -> showSnackBar(it.message!!)
                State.SUCCESS -> showSnackBar(it.message!!)
                State.ERROR -> showSnackBar(it.message!!)
            }
        })

        viewModel.getCountryAndNewCasesList().observe(viewLifecycleOwner, Observer {
            Log.d("LiveByCountryFrag", it.toString())
        })
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(frame_layout, message, Snackbar.LENGTH_LONG).show()
    }
}
