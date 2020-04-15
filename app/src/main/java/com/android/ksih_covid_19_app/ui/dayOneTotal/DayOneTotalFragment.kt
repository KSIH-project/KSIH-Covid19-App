package com.android.ksih_covid_19_app.ui.dayOneTotal

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.utility.Constants.COUNTRY_BUNDLE_CODE
import com.android.ksih_covid_19_app.utility.State
import com.android.ksih_covid_19_app.utility.adapter.CountryAdapter
import com.android.ksih_covid_19_app.utility.adapter.MarginItemDecoration
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_day_one_total.*

class DayOneTotalFragment : Fragment(R.layout.fragment_day_one_total),
    CountryAdapter.OnCovidItemClickListener {

    private lateinit var dayOneViewModel: DayOneTotalViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        day_one_recyclerView.addItemDecoration(MarginItemDecoration(16))
        dayOneViewModel = ViewModelProvider(requireActivity()).get(DayOneTotalViewModel::class.java)
        dayOneViewModel.responseMessage.observe(viewLifecycleOwner, Observer {
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

        dayOneViewModel.getDayOneCasesList().observe(viewLifecycleOwner, Observer { countryList ->
            val countries = countryList.filter { country ->
                country.TotalConfirmed > 0
            }
            val adapter =
                CountryAdapter(
                    this
                )
            adapter.displayData(countries)
            day_one_recyclerView.adapter = adapter
            Log.d("DayOneTotalFragment", adapter.itemCount.toString())
        })

        swipeRefresh_day_one.setOnRefreshListener {
            dayOneViewModel.refreshList()
        }
    }

    /**
     * Navigate to country details
     */
    override fun onItemClick(item: Country) {
        Navigation.findNavController(requireView()).navigate(
            R.id.dayOneTotalDetailsFragment, bundleOf(
                Pair(COUNTRY_BUNDLE_CODE, item)
            )
        )
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(swipeRefresh_day_one, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean) {
        swipeRefresh_day_one.isRefreshing = value
    }
}
