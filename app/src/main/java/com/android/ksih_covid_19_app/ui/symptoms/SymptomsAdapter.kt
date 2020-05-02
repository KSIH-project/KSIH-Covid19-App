package com.android.ksih_covid_19_app.ui.symptoms

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R

class SymptomsAdapter(val context: Context, var symptomsList: List<SymptomsData>) :
    RecyclerView.Adapter<SymptomsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val itemView = layoutInflater.inflate(R.layout.symptoms_list_row, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = symptomsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val symptomsData = symptomsList[position]
        holder.setData(symptomsData)
        holder.pos = position
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView
        lateinit var symptomText:TextView
        lateinit var image:ImageView
        var pos = -1
        fun setData(symptoms: SymptomsData) {
            title = itemView.findViewById(R.id.text_symptoms_tittle)
            symptomText = itemView.findViewById(R.id.text_symptoms_tittle)
            image = itemView.findViewById(R.id.imageView_symptoms)
            title.setText(symptoms.title)
            symptomText.text = symptoms.symptomType
            image.setImageResource(symptoms.image)
            itemView.setOnClickListener {
                val view = View.inflate(context,R.layout.symptoms_alert_dialog,null)
                val dialog = AlertDialog.Builder(context)
                dialog.setView(view)
                val tittle: TextView = view.findViewById(R.id.text_alert_tittle)
                val body: TextView = view.findViewById(R.id.text_alert_dialog_body)
                tittle.text = symptoms.title
                body.text = symptoms.symptoms
                dialog.create().show()

            }
        }
    }


}