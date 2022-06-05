package com.ilizma.dashboard.view.bind

import com.ilizma.dashboard.presentation.model.HistoricData
import com.ilizma.dashboard.view.databinding.WidgetBinding

interface WidgetBinder {

    fun bind(binding: WidgetBinding, data: HistoricData)

    fun unBind()

}