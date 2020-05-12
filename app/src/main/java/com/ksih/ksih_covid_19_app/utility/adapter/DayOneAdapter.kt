package com.ksih.ksih_covid_19_app.utility.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ksih.ksih_covid_19_app.R
import com.ksih.ksih_covid_19_app.model.DayOneTotalResponseItem
import kotlinx.android.synthetic.main.item_day_one_list.view.*

/**
 * Created by SegunFrancis
 */
class DayOneAdapter :
    ListAdapter<DayOneTotalResponseItem, DayOneAdapter.DayOneViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayOneViewHolder =
        DayOneViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_day_one_list,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DayOneViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DayOneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: DayOneTotalResponseItem) = with(itemView) {
            day_one_cases_textView.text = item.Cases.toString()
            day_one_status_textView.text = item.Status
            day_one_date_textView.text =
                "Date: ${item.Date.removeRange(item.Date.indexOf("T") until item.Date.length)}"
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<DayOneTotalResponseItem>() {

        override fun areItemsTheSame(
            oldItem: DayOneTotalResponseItem,
            newItem: DayOneTotalResponseItem
        ): Boolean {
            return oldItem.CountryCode == newItem.CountryCode
        }

        override fun areContentsTheSame(
            oldItem: DayOneTotalResponseItem,
            newItem: DayOneTotalResponseItem
        ): Boolean {
            return oldItem.equals(newItem)
        }
    }
}