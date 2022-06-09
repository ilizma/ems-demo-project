package com.ilizma.ems.flow.navigator

import android.app.Activity
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DashboardScreenBackCloseNavigatorImpTest {

    @RelaxedMockK
    private lateinit var activity: Activity

    private lateinit var navigator: DashboardScreenBackCloseNavigator

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
        navigator = DashboardScreenBackCloseNavigatorImp(
            activity = activity,
        )
    }

    @Nested
    inner class Navigate {

        @Test
        fun `when close is called, then finish is executed`() {
            // when
            navigator.close()

            // then
            verify { activity.finish() }
        }

    }

}