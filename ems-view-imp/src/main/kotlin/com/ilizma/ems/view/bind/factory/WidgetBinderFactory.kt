package com.ilizma.ems.view.bind.factory

import com.ilizma.ems.view.bind.WidgetBinder
import com.ilizma.ems.view.bind.WidgetBinderImp

class WidgetBinderFactory {

    fun create(
        onClicked: (String) -> Unit,
    ): WidgetBinder = WidgetBinderImp(
        onClicked
    )

}