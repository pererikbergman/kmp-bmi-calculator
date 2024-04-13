package calculator.components

import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MeasurementSliderView(
    min: Float,
    max: Float,
    steps: Int,
    sliderPosition: Float,
    onPositionUpdated: (Float) -> Unit
) {
    Slider(
        value = sliderPosition,
        valueRange = min..max,
        steps = steps,
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Blue
        ), onValueChange = {
            onPositionUpdated(it)
        }
    )
}

@Preview
@Composable
fun MeasurementSliderViewPreview() {
    MeasurementSliderView(
        min = 0f,
        max = 100f,
        steps = 10,
        sliderPosition = 50f
    ) {

    }
}
        