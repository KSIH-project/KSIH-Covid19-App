package com.android.ksih_covid_19_app.ui.country

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import java.util.jar.Attributes

class CounrtyFragmentAdapter(private val context: Context, private val Country: List<Country>) :
    RecyclerView.Adapter<CounrtyFragmentAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.country_fragment_listitem, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Country = Country
        holder.CountryName?.text = Country.get(position).Country

    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val CountryName = itemView?.findViewById<TextView?>(R.id.textCountryName)
        val TotalCaseConfirm = itemView?.findViewById<TextView?>(R.id.textTotalCasesConfirmed)
        val Image = itemView?.findViewById<ImageView?>(R.id.imageView)
    }

}