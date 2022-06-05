package com.ilizma.dashboard.view.adapter

import android.view.ViewGroup
import com.ilizma.dashboard.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.dashboard.view.adapter.util.WidgetDiffUtil
import com.ilizma.dashboard.view.bind.factory.WidgetBinderFactory
import com.ilizma.dashboard.view.viewholder.WidgetViewHolder
import com.ilizma.dashboard.view.viewholder.factory.WidgetViewHolderFactory

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