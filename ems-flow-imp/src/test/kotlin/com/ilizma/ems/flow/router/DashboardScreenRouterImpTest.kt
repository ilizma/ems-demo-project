package com.ilizma.ems.flow.router

import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.ems.flow.navigator.ChartNavigator
import com.ilizma.ems.flow.navigator.DashboardScreenBackCloseNavigator
import com.ilizma.ems.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.ems.view.router.DashboardScreenRouter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DashboardScreenRouterImpTest {

    @RelaxedMockK
    private lateinit var lifecycleOwner: LifecycleOwner

    @RelaxedMockK
    private lateinit var onBackPressedDispatcher: OnBackPressedDispatcher

    @RelaxedMockK
    private lateinit var viewModel: DashboardScreenViewModel

    @RelaxedMockK
    private lateinit var viewModelLazy: Lazy<DashboardScreenViewModel>

    @RelaxedMockK
    private lateinit var backCloseNavigator: DashboardScreenBackCloseNavigator

    @RelaxedMockK
    private lateinit var chartNavigator: ChartNavigator

    private lateinit var router: DashboardScreenRouter

    init {
        MockKAnnotations.init(this)
        every { viewModelLazy.value } returns viewModel
    }

    @BeforeEach
    private fun setup() {
        router = DashboardScreenRouterImp(
            lifecycleOwner = { lifecycleOwner },
            onBackPressedDispatcher = onBackPressedDispatcher,
            viewModelLazy = viewModelLazy,
            backCloseNavigator = backCloseNavigator,
            chartNavigator = chartNavigator,
        )
    }

    @Nested
    inner class Init {

        @Test
        fun `when router is initialized, then viewModel functions are called`() {
            // when
            router.init()

            // then
            verify { viewModel.navigationAction.observe(any(), any()) }
        }

    }

}