package com.android.ksih_covid_19_app.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.android.ksih_covid_19_app.R
import kotlinx.android.synthetic.main.home_fragment.*
import java.text.DecimalFormat

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        viewModel.global.observe(viewLifecycleOwner, Observer {
            it?.let{
                val cases = DecimalFormat("#,###")
                total_word_cases.text = cases.format(it.TotalConfirmed)
                total_death.text = cases.format(it.TotalDeaths)
                total_recovered.text = cases.format(it.TotalRecovered)
            }
        })

        viewModel.countries.observe(viewLifecycleOwner, Observer {

            it?.let {
                val nigeria = it.find { country ->
                    country.Country == "Nigeria" }
                nigeria?.let {
                    val cases = DecimalFormat("#,###")
                    nigeria_totalCase.text = cases.format(nigeria.TotalConfirmed)
                }

            }

        })
        materialCardWorldData.setOnClickListener{
            val bundle = Bundle()
            bundle.putInt("chart",0)
            findNavController(it).navigate(R.id.action_homeFragment_to_barChartFragment, bundle)
        }

        materialCardNigeria.setOnClickListener{
            val bundle = Bundle()
            bundle.putInt("chart",1)
            findNavController(it).navigate(R.id.action_homeFragment_to_barChartFragment, bundle)
        }

       materialCardCountry.setOnClickListener {
            findNavController(it).navigate(R.id.countryFragment)
        }

        materialCardCountryAndStatus.setOnClickListener {
            findNavController(it).navigate(R.id.liveByCountryAndStatusFragment)
        }
        materialCardDayOneTotal.setOnClickListener {
            findNavController(it).navigate(R.id.dayOneTotalFragment)
        }

        cardViewSummary.setOnClickListener {
            findNavController(it).navigate(R.id.summaryFragment)
        }

        who_guide_tips.setOnClickListener {
            findNavController(it).navigate(R.id.bottomSheet)

        }
    }

}