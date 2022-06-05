package com.ilizma.dashboard.view.adapter

import androidx.recyclerview.widget.ListAdapter
import com.ilizma.dashboard.presentation.model.HistoricData
import com.ilizma.dashboard.view.adapter.util.WidgetDiffUtil
import com.ilizma.dashboard.view.viewholder.WidgetViewHolder

abstract class DashboardAdapter(
        diffUtil: WidgetDiffUtil,
) : ListAdapter<HistoricData, WidgetViewHolder>(
        diffUtil,
)