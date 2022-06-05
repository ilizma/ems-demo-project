package com.ilizma.ems.view.adapter.util

import com.ilizma.ems.presentation.model.HistoricData

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