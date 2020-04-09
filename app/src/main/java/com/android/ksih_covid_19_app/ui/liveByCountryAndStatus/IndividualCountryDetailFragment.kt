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
import kotlinx.android.synthetic.main.fragment_individual_country_detail.*

/**
 * A simple [Fragment] subclass.
 */
class IndividualCountryDetailFragment : Fragment(R.layout.fragment_individual_country_detail) {
    private val viewModel: IndividualCountryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLiveByCountryRemote("nigeria")

        viewModel.getLiveByCountryLocal("nigeria").observe(viewLifecycleOwner, Observer {
            Log.d("LiveByCountryFragment", it.toString())
        })

        viewModel.responseMessage.observe(viewLifecycleOwner, Observer {
            when(it.status) {
                State.LOADING -> showSnackBar(it.message!!)
                State.SUCCESS -> showSnackBar(it.message!!)
                State.ERROR -> showSnackBar(it.message!!)
            }
        })
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(root, message, Snackbar.LENGTH_LONG).show()
    }
}
