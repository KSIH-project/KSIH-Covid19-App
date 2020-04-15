package com.android.ksih_covid_19_app.ui.dayOneTotal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.utility.Constants.COUNTRY_BUNDLE_CODE
import com.android.ksih_covid_19_app.utility.Constants.toFlagEmoji
import com.android.ksih_covid_19_app.utility.State
import com.android.ksih_covid_19_app.utility.adapter.DayOneAdapter
import com.android.ksih_covid_19_app.utility.adapter.MarginItemDecoration
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_day_one_total_details.*

/**
 * A simple [Fragment] subclass.
 */
class DayOneTotalDetailsFragment : Fragment(R.layout.fragment_day_one_total_details) {

    private lateinit var viewModel: DayOneTotalViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(DayOneTotalViewModel::class.java)
        day_one_details_recyclerView.addItemDecoration(MarginItemDecoration(16))
        val adapter = DayOneAdapter()

        if (arguments != null) {
            val country = requireArguments().getSerializable("country") as Country
            day_one_emojiTextView.text = country.CountryCode.toFlagEmoji()
            viewModel.getDayOneTotal(country.Country)
            viewModel.dayOneResponseMessage.observe(viewLifecycleOwner, Observer { singleEvent ->
                singleEvent.getContentIfNotHandled()?.let { result ->
                    when (result.status) {
                        State.LOADING -> {
                            refresh(result.isRefreshing!!)
                        }
                        State.SUCCESS -> {
                            adapter.submitList(result.data)
                            day_one_details_recyclerView.adapter = adapter
                            refresh(result.isRefreshing!!)
                        }
                        State.ERROR -> {
                            refresh(result.isRefreshing!!)
                            showSnackBar(result.message!!)
                        }
                    }
                }
            })
        }

        day_one_details_swipeRefresh.setOnRefreshListener {
            val country = requireArguments().getSerializable(COUNTRY_BUNDLE_CODE) as Country
            viewModel.getDayOneTotal(country.Country)
        }
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(day_one_details_swipeRefresh, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean) {
        day_one_details_swipeRefresh.isRefreshing = value
    }
}
