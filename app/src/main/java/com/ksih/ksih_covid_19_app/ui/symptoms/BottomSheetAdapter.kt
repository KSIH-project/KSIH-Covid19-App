package com.ksih.ksih_covid_19_app.ui.symptoms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ksih.ksih_covid_19_app.R

class BottomSheetAdapter(val context: Context, var bottomSheetItems: List<PreventionDialogFragment.BottomSheetItems>) :
    RecyclerView.Adapter<BottomSheetAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val itemView = layoutInflater.inflate(R.layout.bottom_sheet_recycler_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = bottomSheetItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sheetItem = bottomSheetItems[position]
        holder.setData(sheetItem)

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView
        lateinit var body: TextView
        lateinit var image: ImageView


        fun setData(sheetItem: PreventionDialogFragment.BottomSheetItems) {
            title = itemView.findViewById(R.id.text_bottom_sheet_item_tittle)
            title.text = context.resources.getString(sheetItem.tittle)
            body = itemView.findViewById(R.id.text_bottom_sheet_item_contents)
            body.text = context.resources.getString(sheetItem.body)
            image = itemView.findViewById(R.id.image_bottom_sheet_icon)
            image.setImageResource(sheetItem.image)

        }
    }


}