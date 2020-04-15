package com.android.ksih_covid_19_app.ui.country

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.utility.State
import com.android.ksih_covid_19_app.utility.adapter.CountryAdapter
import com.android.ksih_covid_19_app.utility.adapter.MarginItemDecoration
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.country_fragment.*

class CountryFragment : Fragment(R.layout.country_fragment), CountryAdapter.OnCovidItemClickListener  {

    private lateinit var viewModel: CountryViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        country_recyclerView.addItemDecoration(
            MarginItemDecoration(
                16
            )
        )
        viewModel =
            ViewModelProvider(requireActivity()).get(CountryViewModel::class.java)
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
                country.TotalConfirmed > 0
            }
            val adapter =
                CountryAdapter(
                    this
                )
            adapter.displayData(countries)
            country_recyclerView.adapter = adapter
            Log.d("TotalCountrySize", adapter.itemCount.toString())
        })

        country_swipeRefresh.setOnRefreshListener {
            viewModel.refreshList()
        }
    }
    /**
     * Navigate to bottomSheetDialog
     */
    override fun onItemClick(item: Country) {
        val individualCountry = CountryDetailFragment()
        individualCountry.arguments = bundleOf(Pair("country", item))
        individualCountry.show(requireActivity().supportFragmentManager, "countryFragment")
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(country_swipeRefresh, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean) {
        country_swipeRefresh.isRefreshing = value
    }
}
