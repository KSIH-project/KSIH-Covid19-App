package com.android.ksih_covid_19_app.ui.symptoms

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.method.DialerKeyListener
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.android.ksih_covid_19_app.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.item_live_by_country_list.*
import kotlinx.android.synthetic.main.prevention_bottom_sheet.*
import java.io.Serializable

/**
 * A simple [Fragment] subclass.
 */
class SymptomsFragment : Fragment() {

    private var fever = SymptomsData(
        "Fever",
        "This means you feel hot to touch on your chest or back (you do not need to measure your temperature). It is a common sign & also may appear in 2-10 days if affected."
    )
    private var cough = SymptomsData(
        "COUGH",
        "This means coughing a lot for more than an hour, or 3 or more coughing episodes in 24 hours (if you usually have a cough, it may be worse than usual)"
    )
    private val shortnessofbreath = SymptomsData(
        "SHORTNESS OF BREATH",
        "Around 1 out of every 6 people who gets COVID-19 becomes seriously ill and develops difficulty breathing or shortness of breath."
    )

    var symptomsList: List<SymptomsData> = arrayListOf(fever, cough, shortnessofbreath)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_symptoms, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SymptomsAdapter(requireContext(), symptomsList)
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}

data class SymptomsData(val title: String, val symptoms: String) : Serializable
