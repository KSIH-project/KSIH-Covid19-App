package com.android.ksih_covid_19_app.ui.symptoms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R
import java.io.Serializable

/**
 * A simple [Fragment] subclass.
 */
class SymptomsFragment : Fragment() {

    private var fever = SymptomsData(
        "Fever",
        "This means you feel hot to touch on your chest or back (you do not need to measure your temperature). It is a common sign & also may appear in 2-10 days if affected.",
        R.drawable.fever,"High Fever"
    )
    private var cough = SymptomsData(
        "COUGH",
        "This means coughing a lot for more than an hour, or 3 or more coughing episodes in 24 hours (if you usually have a cough, it may be worse than usual)",
        R.drawable.cough_1,"Continuous cough"
    )
    private val shortnessOfBreath = SymptomsData(
        "SHORTNESS OF BREATH",
        "Around 1 out of every 6 people who gets infected becomes seriously ill and develops difficulty breathing or shortness of breath.",
        R.drawable.cough_1,"Difficulty breathing"
    )

    var symptomsList: List<SymptomsData> = arrayListOf(fever, cough, shortnessOfBreath)

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
}

data class SymptomsData(val title: String, val symptoms: String, val image : Int, val symptomType: String) : Serializable
