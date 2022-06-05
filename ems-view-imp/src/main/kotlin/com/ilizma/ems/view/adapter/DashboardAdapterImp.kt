package com.ilizma.ems.view.adapter

import android.view.ViewGroup
import com.ilizma.ems.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.ems.view.adapter.util.WidgetDiffUtil
import com.ilizma.ems.view.bind.factory.WidgetBinderFactory
import com.ilizma.ems.view.viewholder.WidgetViewHolder
import com.ilizma.ems.view.viewholder.factory.WidgetViewHolderFactory

class DashboardAdapterImp(
    private val binderFactory: WidgetBinderFactory,
    diffUtil: WidgetDiffUtil,
    private val viewHolderFactory: WidgetViewHolderFactory,
    private val viewModel: DashboardScreenViewModel,
) : DashboardAdapter(diffUtil) {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int,
    ): WidgetViewHolder = viewHolderFactory.create(
            binderFactory = binderFactory,
            parent = parent,
            onClicked = { viewModel.onClick(it) },
    )

    override fun onBindViewHolder(holder: WidgetViewHolder, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    override fun onViewRecycled(holder: WidgetViewHolder) {
        super.onViewRecycled(holder)
        holder.unBind()
    }

}