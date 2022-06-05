package com.ilizma.ems.view.bind

import com.ilizma.ems.presentation.model.HistoricData
import com.ilizma.ems.view.databinding.WidgetBinding

interface WidgetBinder {

    fun bind(binding: WidgetBinding, data: HistoricData)

    fun unBind()

}