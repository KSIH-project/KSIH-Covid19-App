package com.android.ksih_covid_19_app.utility.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.utility.Constants.toFlagEmoji
import kotlinx.android.synthetic.main.item_live_by_country_list.view.*

/**
 * Created by SegunFrancis
 */
class CountryAdapter(private val listener: OnCovidItemClickListener) :
    ListAdapter<Country, CountryAdapter.LiveByCountryViewHolder>(CountryDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveByCountryViewHolder {
        return LiveByCountryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_live_by_country_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LiveByCountryViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
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
            else
                new_cases_textView.text = "${item.TotalConfirmed} case"
            country_code_textView.text = item.CountryCode.toFlagEmoji()

            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    class CountryDiffUtil : DiffUtil.ItemCallback<Country>() {

        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.CountryCode == newItem.CountryCode
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.equals(newItem)
        }
    }
}