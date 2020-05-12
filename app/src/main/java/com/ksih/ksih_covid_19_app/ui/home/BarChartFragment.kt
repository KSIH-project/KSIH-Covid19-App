package com.ksih.ksih_covid_19_app.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.ksih.ksih_covid_19_app.R
import kotlinx.android.synthetic.main.bar_chart_fragment.*

class BarChartFragment : Fragment() {


    private lateinit var viewModel: BarChartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bar_chart_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BarChartViewModel::class.java)


        if (arguments?.get("chart") == 0 ){
        viewModel.global.observe(viewLifecycleOwner, Observer {
            it?.let {
                val barEntry = arrayListOf(
                    PieEntry( it.TotalRecovered.toFloat(),"TotalRecovered"),
                    PieEntry( it.TotalDeaths.toFloat(),"TotalDeaths"),
                    PieEntry( it.TotalConfirmed.toFloat(),"TotalConfirmed")
                )

                val barDataSet = PieDataSet(barEntry, "World infection rate")
                chart.animate()
                val data = PieData(barDataSet)
                barDataSet.setColors( ContextCompat.getColor(chart.context, R.color.recovered_green),
                    ContextCompat.getColor(chart.context, R.color.daeths_red),
                    ContextCompat.getColor(chart.context, R.color.infected_yellow))

                chart.centerText = "World cases"
                chart.setDrawEntryLabels(true)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    chart.setCenterTextTypeface(activity?.resources?.getFont(R.font.sanchez))
                }

                chart.data = data
                chart.invalidate()
            }



        })
        }else {
        viewModel.countries.observe(viewLifecycleOwner, Observer {
            val nigeria = it.find { country -> country.Country == "Nigeria" }
            nigeria?.let {
                val barEntry = arrayListOf(
                    PieEntry( nigeria.TotalRecovered.toFloat(),"TotalRecovered"),
                    PieEntry( nigeria.TotalDeaths.toFloat(),"TotalDeaths"),
                    PieEntry( nigeria.TotalConfirmed.toFloat(),"TotalConfirmed")
                )

                val barDataSet = PieDataSet(barEntry, "Nigeria infection rate")
                chart.animate()
                val data = PieData(barDataSet)
                barDataSet.setColors( ContextCompat.getColor(chart.context, R.color.recovered_green),
                    ContextCompat.getColor(chart.context, R.color.daeths_red),
                    ContextCompat.getColor(chart.context, R.color.infected_yellow))

                chart.centerText = "Nigeria cases"
                chart.setDrawEntryLabels(true)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    chart.setCenterTextTypeface(activity?.resources?.getFont(R.font.sanchez))
                }

                chart.data = data
                chart.invalidate()
            }




        })


        }

    }


}
