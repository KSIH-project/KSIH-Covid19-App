package com.android.ksih_covid_19_app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController

import com.android.ksih_covid_19_app.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.prevention_bottom_sheet.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Todo: Remove temporary navigation

        button_total_cases.setOnClickListener {
            findNavController(it).navigate(R.id.countryFragment)
        }
        button_live_cases.setOnClickListener {
            findNavController(it).navigate(R.id.liveByCountryAndStatusFragment)
        }
        button_day_one_cases.setOnClickListener {
            findNavController(it).navigate(R.id.dayOneTotalFragment)
        }

        val bottomSheetBehavior =
            BottomSheetBehavior.from(prevention_bottom_sheet)

        floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, "  Prevention is better than Cure", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED


                bottomSheetBehavior.setBottomSheetCallback(object :
                    BottomSheetBehavior.BottomSheetCallback() {

                    override fun onStateChanged(view: View, state: Int) {
                        when (state) {
                            BottomSheetBehavior.STATE_EXPANDED -> {
                                floatingActionButton.visibility = View.GONE
                            }
                            BottomSheetBehavior.STATE_COLLAPSED -> {
                                floatingActionButton.visibility = View.VISIBLE
                            }
                        }
                    }

                    override fun onSlide(view: View, p1: Float) {
                    }
                })
            }
        }
    }

}
