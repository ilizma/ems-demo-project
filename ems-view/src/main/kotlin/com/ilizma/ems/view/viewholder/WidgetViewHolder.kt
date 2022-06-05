package com.ilizma.ems.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ilizma.ems.presentation.model.HistoricData

abstract class WidgetViewHolder(
        itemView: View,
) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(data: HistoricData)

    abstract fun unBind()

} 