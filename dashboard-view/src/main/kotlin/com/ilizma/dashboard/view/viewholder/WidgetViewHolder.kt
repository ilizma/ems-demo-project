package com.ilizma.dashboard.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ilizma.dashboard.presentation.model.HistoricData

abstract class WidgetViewHolder(
        itemView: View,
) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(data: HistoricData)

    abstract fun unBind()

} 