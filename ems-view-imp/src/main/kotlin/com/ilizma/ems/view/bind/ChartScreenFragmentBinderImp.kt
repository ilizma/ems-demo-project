package com.ilizma.ems.view.bind

import android.content.Context
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.ilizma.ems.presentation.model.ChartState
import com.ilizma.ems.presentation.model.HistoricData
import com.ilizma.ems.presentation.viewmodel.ChartScreenViewModel
import com.ilizma.ems.view.databinding.ChartScreenFragmentBinding
import com.ilizma.resources.R
import com.ilizma.view.extensions.snackbar

class ChartScreenFragmentBinderImp(
    viewModelLazy: Lazy<ChartScreenViewModel>,
    private val lifecycleOwner: () -> LifecycleOwner,
) : ChartScreenFragmentBinder {

    private val viewModel by viewModelLazy
    private lateinit var binding: ChartScreenFragmentBinding

    override fun bind(binding: ChartScreenFragmentBinding) {
        this.binding = binding
        setupToolbar()
        setupObservers()
    }

    private fun setupToolbar() {
        binding.chartScreenT.setNavigationIcon(R.drawable.ic_back)
        binding.chartScreenT.setNavigationOnClickListener { viewModel.onBack() }
    }

    private fun setupObservers() {
        viewModel.chart.observe(
            lifecycleOwner(),
            ::onChartState,
        )
        viewModel.error.observe(
            lifecycleOwner(),
            ::onError,
        )
    }

    private fun onChartState(
        state: ChartState,
    ) {
        binding.chartScreenCpiLoading.isVisible = state == ChartState.Loading
        binding.chartScreenAacvChart.isVisible = state != ChartState.Loading
        when (state) {
            is ChartState.Success -> with(binding.root.context) {
                AAChartModel()
                    .chartType(AAChartType.Line)
                    .zoomType(AAChartZoomType.X)
                    .yAxisTitle(getString(R.string.kW))
                    .tooltipValueSuffix(getString(R.string.kW))
                    .categories(state.data.dateList.toTypedArray())
                    .series(state.data.createColumnsArray(this))
                    .let { binding.chartScreenAacvChart.aa_drawChartWithChartModel(it) }
            }

        }

    }

    private fun onError(
        error: ChartState.Error
    ) {
        binding.root.snackbar(
            title = error.message,
            action = binding.root.context.getString(R.string.retry),
        ) { viewModel.getChart() }
    }

    private fun HistoricData.createColumnsArray(
        context: Context,
    ): Array<Any> = arrayOf(
        AASeriesElement()
            .name(context.getString(R.string.buildingActive))
            .data(buildingActive.toTypedArray()),
        AASeriesElement()
            .name(context.getString(R.string.gridActive))
            .data(gridActive.toTypedArray()),
        AASeriesElement()
            .name(context.getString(R.string.pvActive))
            .data(pvActive.toTypedArray()),
        AASeriesElement()
            .name(context.getString(R.string.quasarsActive))
            .data(quasarsActive.toTypedArray()),
    )

}