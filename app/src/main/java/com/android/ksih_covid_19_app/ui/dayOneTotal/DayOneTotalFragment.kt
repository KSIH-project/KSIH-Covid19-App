package com.android.ksih_covid_19_app.ui.dayOneTotal

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
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
    private lateinit var toolbar: Toolbar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.main_menu)

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
            adapter.submitList(countries)
            day_one_recyclerView.adapter = adapter
            Log.d("DayOneTotalFragment", adapter.itemCount.toString())
        })

        swipeRefresh_day_one.setOnRefreshListener {
            dayOneViewModel.refreshList()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
        val searchMenu = menu.findItem(R.id.menu_search)
        val searchView = searchMenu.actionView as SearchView
        searchView.setOnQueryTextListener( object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }
        })
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
