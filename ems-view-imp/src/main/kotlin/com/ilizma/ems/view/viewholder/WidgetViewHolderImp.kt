package com.ilizma.ems.view.viewholder

import com.ilizma.ems.presentation.model.HistoricData
import com.ilizma.ems.view.bind.WidgetBinder
import com.ilizma.ems.view.databinding.WidgetBinding

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