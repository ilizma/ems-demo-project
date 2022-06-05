package com.ilizma.ems.view.viewholder.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ilizma.ems.view.bind.factory.WidgetBinderFactory
import com.ilizma.ems.view.databinding.WidgetBinding
import com.ilizma.ems.view.viewholder.WidgetViewHolder
import com.ilizma.ems.view.viewholder.WidgetViewHolderImp

class WidgetViewHolderFactory {

    fun create(
        binderFactory: WidgetBinderFactory,
        parent: ViewGroup,
        onClicked: (String) -> Unit,
    ): WidgetViewHolder = LayoutInflater.from(parent.context)
        .let { WidgetBinding.inflate(it, parent, false) }
        .let { WidgetViewHolderImp(binderFactory.create(onClicked), it) }

}