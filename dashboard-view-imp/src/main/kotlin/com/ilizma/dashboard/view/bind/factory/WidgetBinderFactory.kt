package com.ilizma.dashboard.view.bind.factory

import com.ilizma.dashboard.view.bind.WidgetBinder
import com.ilizma.dashboard.view.bind.WidgetBinderImp

class WidgetBinderFactory {

    fun create(
        onClicked: (String) -> Unit,
    ): WidgetBinder = WidgetBinderImp(
        onClicked
    )

}