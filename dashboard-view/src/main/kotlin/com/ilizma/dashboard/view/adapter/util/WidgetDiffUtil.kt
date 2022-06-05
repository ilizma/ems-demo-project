package com.ilizma.dashboard.view.adapter.util

import androidx.recyclerview.widget.DiffUtil
import com.ilizma.dashboard.presentation.model.HistoricData

abstract class WidgetDiffUtil : DiffUtil.ItemCallback<HistoricData>()