package com.android.ksih_covid_19_app.ui.symptoms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R


/**
 * A simple [Fragment] subclass.
 */
@Suppress("UNREACHABLE_CODE")
class PreventionDialogFragment : RoundedBottomSheetDialogFragment() {

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
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter  = BottomSheetAdapter(requireContext(),items)
        return view
    }






}

data class BottomSheetItems(val image:Int , val tittle:Int, val body:Int)


