package com.android.ksih_covid_19_app.ui.symptoms

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.android.ksih_covid_19_app.R
import org.jetbrains.anko.support.v4.progressDialog


/**
 * A simple [Fragment] subclass.
 */
@Suppress("UNREACHABLE_CODE")
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


        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setIcon(R.drawable.symptoms)
            .setTitle(R.string.title_dialog)
            .setMessage(R.string.symptom_dialog)

        return root
    }

}


