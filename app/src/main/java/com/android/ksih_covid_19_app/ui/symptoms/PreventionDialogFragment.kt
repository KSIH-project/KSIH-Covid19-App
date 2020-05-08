package com.android.ksih_covid_19_app.ui.symptoms

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.prevention_bottom_sheet.*
import java.text.DecimalFormat


/**
 * created by CHukwuwaUchenna
 *[BottomSheetDialogFragment] that uses a custom
 * theme which gives the bottomSheet rounded corners
 * and dose not dim the navigation bar if any
 */

class PreventionDialogFragment : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog  = BottomSheetDialog(requireContext(),theme)

    private val items = arrayListOf(BottomSheetItems(R.drawable.wash_hands,R.string.bottom_sheet_item_tittle_1,R.string.bottom_sheet_item_body_1),
        BottomSheetItems(R.drawable.social_distance,R.string.bottom_sheet_item_tittle_2,R.string.bottom_sheet_item_body_2),
        BottomSheetItems(R.drawable.dont_touch_face,R.string.bottom_sheet_item_tittle_3,R.string.bottom_sheet_item_body_3),
        BottomSheetItems(R.drawable.respiratory_hygiene,R.string.bottom_sheet_item_tittle_4,R.string.bottom_sheet_item_body_4)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(activity,R.layout.prevention_bottom_sheet,null)
        val recyclerView:RecyclerView = view.findViewById(R.id.recycler_bottom_sheet)
        val fab = view.findViewById<RoundedImageView>(R.id.bottom_sheet_fab)
        val application = requireNotNull(this.activity).application
        val viewModelFactory = PreventionViewModelFactory(application)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(PreventionViewModel(application)::class.java)
            fab.setOnClickListener {
         Navigation.findNavController(requireParentFragment().requireView()).navigate(R.id.action_bottomSheet_to_symptomsFragment)
        }

        viewModel.getGlobal().observe(this, Observer {

          it?.let {
              val cases = DecimalFormat("#,###")
           text_cases.text = cases.format(it.TotalConfirmed)

        }})
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter  = BottomSheetAdapter(requireContext(),items)



        return view


    }
    data class BottomSheetItems(val image:Int , val tittle:Int, val body:Int)
}




