package com.android.ksih_covid_19_app.ui.symptoms

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment

import com.android.ksih_covid_19_app.R

/**
 * A simple [Fragment] subclass.
 */
class SymptomsDialogFragment : DialogFragment() {

    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val style = DialogFragment.STYLE_NO_FRAME
        val theme = R.style.DialogTheme
        setStyle(style, theme)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_symptoms_dialog, container, false)

        val symptoms = arguments?.getSerializable("symptoms") as SymptomsData
        val title = root.findViewById<TextView>(R.id.texttitle)
        val textsymptoms = root.findViewById<TextView>(R.id.textsymptoms)
        title.text = symptoms.title
        textsymptoms.text = symptoms.symptoms

        Log.d("dialogFragment", "DialogText ${symptoms}")
        return root


    }


}