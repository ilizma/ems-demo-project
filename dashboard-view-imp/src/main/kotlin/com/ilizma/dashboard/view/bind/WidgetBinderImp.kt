package com.ilizma.dashboard.view.bind

import com.ilizma.dashboard.presentation.model.HistoricData
import com.ilizma.dashboard.view.databinding.WidgetBinding

class WidgetBinderImp(
    private val onClicked: (String) -> Unit
) : WidgetBinder {

    private lateinit var binding: WidgetBinding

    override fun bind(binding: WidgetBinding, data: HistoricData) {
        this.binding = binding
        setupView(data)
    }

    override fun unBind() {
        binding.widgetCvContent.setOnClickListener(null)
    }

    private fun setupView(data: HistoricData) {
        binding.widgetTvBuilding.text = data.buildingActivePower.toString()
        binding.widgetTvGrid.text = data.gridActivePower.toString()
        binding.widgetTvPv.text = data.pvActivePower.toString()
        binding.widgetTvQuasars.text = data.quasarsActivePower.toString()
        binding.widgetTvDate.text = data.date
        binding.widgetCvContent.setOnClickListener { onClicked(data.id) }
    }

}