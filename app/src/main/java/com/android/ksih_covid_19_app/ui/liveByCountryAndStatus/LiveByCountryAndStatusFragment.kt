package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus

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
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.utility.Constants.COUNTRY_BUNDLE_CODE
import com.android.ksih_covid_19_app.utility.State
import com.android.ksih_covid_19_app.utility.adapter.LiveByCountryAdapter
import com.android.ksih_covid_19_app.utility.adapter.MarginItemDecoration
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.live_by_country_and_status_fragment.*

class LiveByCountryAndStatusFragment : Fragment(R.layout.live_by_country_and_status_fragment),
    LiveByCountryAdapter.OnCovidItemClickListener {
    private lateinit var toolbar: MaterialToolbar

    private lateinit var viewModel: LiveByCountryAndStatusViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.material_toolbar)
        toolbar.inflateMenu(R.menu.main_menu)

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

        viewModel.getCountriesFromLocal().observe(viewLifecycleOwner, Observer { countryList ->
            val countries = countryList.filter { country ->
                country.NewConfirmed > 0
            }
            val adapter =
                LiveByCountryAdapter(
                    this
                )
            adapter.submitList(countries)
            live_recyclerView.adapter = adapter
            Log.d("LiveByCountrySize", adapter.itemCount.toString())
        })

        live_swipeRefresh.setOnRefreshListener {
            viewModel.refreshList()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        val searchMenu = menu.findItem(R.id.menu_search)
        val searchView = searchMenu.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.getSearchResults(newText)
                Log.d("QueryTextChange", newText)
                return false
            }
        })
    }


    /**
     * Navigate to bottomSheetDialog
     */
    override fun onItemClick(item: Country) {
        val individualCountry = IndividualCountryDetailFragment()
        individualCountry.arguments = bundleOf(Pair(COUNTRY_BUNDLE_CODE, item))
        individualCountry.show(requireActivity().supportFragmentManager, "individualCountry")
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(live_swipeRefresh, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean) {
        live_swipeRefresh.isRefreshing = value
    }
}
