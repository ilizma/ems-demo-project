package com.ilizma.dashboard.view.viewholder

import com.ilizma.dashboard.presentation.model.HistoricData
import com.ilizma.dashboard.view.bind.WidgetBinder
import com.ilizma.dashboard.view.databinding.WidgetBinding

class WidgetViewHolderImp(
    private val binder: WidgetBinder,
    private val binding: WidgetBinding,
) : WidgetViewHolder(binding.root) {

    override fun bind(data: HistoricData) {
        binder.bind(binding, data)
    }

    override fun unBind() {
        binder.unBind()
    }

}