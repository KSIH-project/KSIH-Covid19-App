package com.android.ksih_covid_19_app.utility.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.utility.Constants.toFlagEmoji
import kotlinx.android.synthetic.main.live_by_country_list_item.view.*
import java.util.ArrayList

/**
 * Created by SegunFrancis
 */
class CountryAdapter(private val listener: OnCovidItemClickListener) :
    RecyclerView.Adapter<CountryAdapter.LiveByCountryViewHolder>() {

    private var countryList: List<Country> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveByCountryViewHolder {
        return LiveByCountryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.live_by_country_list_item, parent, false)
        )
    }

    override fun getItemCount() = countryList.size

    override fun onBindViewHolder(holder: LiveByCountryViewHolder, position: Int) {
        holder.bind(countryList[position], listener)
    }

    fun displayData(countryList: List<Country>) {
        this.countryList = countryList
        notifyDataSetChanged()
    }

    /**
     * Handles recyclerView item click
     */
    interface OnCovidItemClickListener {
        /**
         * Navigate to bottomSheetDialog
         */
        fun onItemClick(item: Country)
    }

    class LiveByCountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Country, listener: OnCovidItemClickListener) = with(itemView) {
            country_name_textView.text = item.Country
            if (item.TotalConfirmed > 1)
                new_cases_textView.text = "${item.TotalConfirmed} cases"
            if (item.TotalConfirmed == 1)
                new_cases_textView.text = "${item.TotalConfirmed} case"
            country_code_textView.text = item.CountryCode.toFlagEmoji()

            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }
}