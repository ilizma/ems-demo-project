package com.ilizma.ems.data.cache

import com.ilizma.ems.data.model.DashboardState
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DashboardCacheImpTest {

    private lateinit var cache: DashboardCache

    @BeforeEach
    private fun setup() {
        cache = DashboardCacheImp()
    }

    @Nested
    inner class GetCache {

        @Test
        fun `given null DashboardState, when cache is called, then result should be the expected`() {
            // given
            val expected = null
            cache.cache = expected

            // when
            val result = cache.cache

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given a DashboardState, when cache is called, then result should be the expected`() {
            // given
            val expected = mockk<DashboardState.Success>()
            cache.cache = expected

            // when
            val result = cache.cache

            // then
            assertEquals(expected, result)
        }

    }

}