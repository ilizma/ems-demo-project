package com.ilizma.dashboard.view.adapter.util

import com.ilizma.dashboard.presentation.model.HistoricData

class WidgetDiffUtilImp : WidgetDiffUtil() {

    override fun areItemsTheSame(
        oldItem: HistoricData,
        newItem: HistoricData,
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
            oldItem: HistoricData,
            newItem: HistoricData,
    ): Boolean = oldItem == newItem

} 