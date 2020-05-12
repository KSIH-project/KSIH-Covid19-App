package com.ksih.ksih_covid_19_app.utility.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ksih.ksih_covid_19_app.R
import com.ksih.ksih_covid_19_app.model.Country
import com.ksih.ksih_covid_19_app.utility.Constants.toFlagEmoji
import kotlinx.android.synthetic.main.item_live_by_country_list.view.*

/**
 * Created by SegunFrancis
 */
class LiveByCountryAdapter(private val listener: OnCovidItemClickListener) :
    ListAdapter<Country, LiveByCountryAdapter.LiveByCountryViewHolder>(LiveByCountryDiff()) {

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
            if (item.NewConfirmed > 1)
                new_cases_textView.text = "${item.NewConfirmed} new cases"
            if (item.NewConfirmed == 1)
                new_cases_textView.text = "${item.NewConfirmed} new case"
            country_code_textView.text = item.CountryCode.toFlagEmoji()

            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    class LiveByCountryDiff : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.CountryCode == newItem.CountryCode
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.equals(newItem)
        }
    }
}