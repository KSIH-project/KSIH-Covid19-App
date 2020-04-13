package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.utility.adapter.LiveByCountryAdapter
import com.android.ksih_covid_19_app.utility.adapter.MarginItemDecoration
import com.android.ksih_covid_19_app.utility.State
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.live_by_country_and_status_fragment.*

class LiveByCountryAndStatusFragment : Fragment(R.layout.live_by_country_and_status_fragment),
    LiveByCountryAdapter.OnCovidItemClickListener {

    private lateinit var viewModel: LiveByCountryAndStatusViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        live_recyclerView.addItemDecoration(
            MarginItemDecoration(
                16
            )
        )
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
            val adapter =
                LiveByCountryAdapter(
                    this
                )
            adapter.displayData(countries)
            live_recyclerView.adapter = adapter
            Log.d("LiveByCountrySize", adapter.itemCount.toString())
        })

        live_swipeRefresh.setOnRefreshListener {
            viewModel.refreshList()
        }
    }

    /**
     * Navigate to bottomSheetDialog
     */
    override fun onItemClick(item: Country) {
        val individualCountry = IndividualCountryDetailFragment()
        individualCountry.arguments = bundleOf(Pair("country", item))
        individualCountry.show(requireActivity().supportFragmentManager, "individualCountry")
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(live_swipeRefresh, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean) {
        live_swipeRefresh.isRefreshing = value
    }
}
