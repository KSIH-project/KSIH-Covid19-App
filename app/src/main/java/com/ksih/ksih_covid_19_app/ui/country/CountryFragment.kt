package com.ksih.ksih_covid_19_app.ui.country

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.ksih.ksih_covid_19_app.R
import com.ksih.ksih_covid_19_app.model.Country
import com.ksih.ksih_covid_19_app.utility.Constants.COUNTRY_BUNDLE_CODE
import com.ksih.ksih_covid_19_app.utility.State
import com.ksih.ksih_covid_19_app.utility.adapter.CountryAdapter
import com.ksih.ksih_covid_19_app.utility.adapter.MarginItemDecoration
import kotlinx.android.synthetic.main.country_fragment.*

class CountryFragment : Fragment(R.layout.country_fragment), CountryAdapter.OnCovidItemClickListener  {

    private lateinit var viewModel: CountryViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

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

        viewModel.getCountriesFromLocal().observe(viewLifecycleOwner, Observer { countryList ->
            val countries = countryList.filter { country ->
                country.TotalConfirmed > 0
            }
            val adapter =
                CountryAdapter(
                    this
                )
            adapter.submitList(countries)
            country_recyclerView.adapter = adapter
            Log.d("TotalCountrySize", adapter.itemCount.toString())
        })

        country_swipeRefresh.setOnRefreshListener {
            viewModel.refreshList()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
        val searchMenu = menu.findItem(R.id.menu_search)
        val searchView = searchMenu.actionView as SearchView
        searchView.setOnQueryTextListener( object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.getSearchResults(newText)
                return false
            }
        })
    }
    /**
     * Navigate to bottomSheetDialog
     */
    override fun onItemClick(item: Country) {
        val individualCountry = CountryDetailFragment()
        individualCountry.arguments = bundleOf(Pair(COUNTRY_BUNDLE_CODE, item))
        individualCountry.show(requireActivity().supportFragmentManager, "countryFragment")
    }


    private fun showSnackBar(message: String) {
        Snackbar.make(country_swipeRefresh, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean) {
       country_swipeRefresh.isRefreshing = value
    }
}




