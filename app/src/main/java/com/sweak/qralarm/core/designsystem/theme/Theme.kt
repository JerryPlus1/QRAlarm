package com.sweak.qralarm.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val ColorScheme = lightColorScheme(
    primary = DoubleArray,
    onPrimary = Color.White,
    secondary = OceanBlue,
    onSecondary = Color.White,
    tertiary = DeepSkyBlue,
    onTertiary = Color.White,
    surface = ButterflyBush,
    onSurface = Color.White,
    onSurfaceVariant = Nobel,
    error = Monza,
    onError = Color.White
)

@Composable
fun QRAlarmTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalSpace provides Space()) {
        MaterialTheme(
            colorScheme = ColorScheme,
            typography = Typography,
            content = content
        )
    }
}