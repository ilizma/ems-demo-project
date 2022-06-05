package com.ilizma.ems.view.adapter.util

import androidx.recyclerview.widget.DiffUtil
import com.ilizma.ems.presentation.model.HistoricData

abstract class WidgetDiffUtil : DiffUtil.ItemCallback<HistoricData>()