package com.ilizma.ems.view.adapter

import androidx.recyclerview.widget.ListAdapter
import com.ilizma.ems.presentation.model.HistoricData
import com.ilizma.ems.view.adapter.util.WidgetDiffUtil
import com.ilizma.ems.view.viewholder.WidgetViewHolder

abstract class DashboardAdapter(
        diffUtil: WidgetDiffUtil,
) : ListAdapter<HistoricData, WidgetViewHolder>(
        diffUtil,
)