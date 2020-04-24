package com.android.ksih_covid_19_app.ui.symptoms

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
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
        var pos = -1
        fun setData(symptoms: SymptomsData) {
            title = itemView.findViewById(R.id.textFeverDialog)
            title.setText(symptoms.title)
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("symptoms", symptomsList[pos])
                Navigation.findNavController(title)
                    .navigate(R.id.action_symptomsFragment_to_symptomsDialogFragment, bundle)
            }
        }
    }


}