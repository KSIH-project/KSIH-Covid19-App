package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.utility.LiveByCountryAdapter
import com.android.ksih_covid_19_app.utility.MarginItemDecoration
import com.android.ksih_covid_19_app.utility.State
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.live_by_country_and_status_fragment.*
import kotlinx.android.synthetic.main.live_by_country_bottom_sheet.*
import kotlinx.android.synthetic.main.live_by_country_bottom_sheet.view.*

class LiveByCountryAndStatusFragment : Fragment(R.layout.live_by_country_and_status_fragment) {

    private lateinit var viewModel: LiveByCountryAndStatusViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        live_recyclerView.addItemDecoration(MarginItemDecoration(16))
        viewModel =
            ViewModelProvider(requireActivity()).get(LiveByCountryAndStatusViewModel::class.java)
        viewModel.responseMessage.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    State.LOADING -> refresh(result.isRefreshing!!)
                    State.SUCCESS -> {
                        showSnackBar(result.message!!)
                        refresh(result.isRefreshing!!)
                    }
                    State.ERROR -> {
                        showSnackBar(result.message!!)
                        refresh(result.isRefreshing!!)
                    }
                }
            }
        })

        viewModel.getCountryAndNewCasesList().observe(viewLifecycleOwner, Observer { countryList ->
            val countries = countryList.filter { country ->
                country.NewConfirmed > 0
            }
            val adapter = LiveByCountryAdapter()
            adapter.displayData(countries)
            live_recyclerView.adapter = adapter
            Log.d("LiveByCountrySize", adapter.itemCount.toString())
        })

        live_swipeRefresh.setOnRefreshListener {
            viewModel.refreshList()
        }

        // Bottom Sheet
        val sheetBehaviour = BottomSheetBehavior.from(live_by_country_bottomSheet)
        if (arguments != null) {
            val country = requireArguments().getSerializable("country") as Country
            bottomSheet_confirmed_textView.text = "New Confirmed: ${country.NewConfirmed}"
            bottomSheet_death_textView.text = "New Deaths: ${country.NewDeaths}"
            bottomSheet_date_textView.text = "Date: ${country.Date.removeRange(country.Date.indexOf("T") until country.Date.length)}"
            bottomSheet_recovered_textView.text = "New Recovered: ${country.NewRecovered}"
            bottomSheet_country_code_textView.text = country.CountryCode
            if (sheetBehaviour.state != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                sheetBehaviour.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

    }

    private fun showSnackBar(message: String) {
        Snackbar.make(live_swipeRefresh, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean) {
        live_swipeRefresh.isRefreshing = value
    }
}
