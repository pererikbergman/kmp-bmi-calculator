package calculator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import calculator.components.BMIBackdropView
import calculator.components.BMIOverlayView
import calculator.components.BodyMeasurementsView
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    val state by viewModel.uiState.collectAsState()

    CalculatorScreen(state) { event ->
        viewModel.onEvent(event)
    }
}

@Composable
fun CalculatorScreen(
    state: CalculatorViewModel.UIState,
    onEvent: (CalculatorViewModel.UIEvent) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            BMIBackdropView(
                modifier = Modifier.fillMaxWidth().weight(0.5f),
                color = state.accentColor
            )
            BodyMeasurementsView(
                modifier = Modifier.fillMaxWidth().weight(0.5f),
                heightCm = state.bodyMeasurements.heightCm,
                heightDisplay = state.heightDisplay,
                weightKg = state.bodyMeasurements.weightKg,
                weightDisplay = state.weightDisplay,
                onEvent = onEvent
            )
        }
        
        BMIOverlayView(state.bmiDisplay)
    }

}

@Preview
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen(CalculatorViewModel.UIState()) {

    }
}