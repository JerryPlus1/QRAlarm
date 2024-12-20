package com.sweak.qralarm.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val ColorScheme = lightColorScheme(
    primary = molandBlue,
    onPrimary = Color.White,
    secondary = OceanBlue,
    onSecondary = Color.White,
    tertiary = LightCoral,
    onTertiary = Color.White,
    surface = DeepSkyBlue,
    onSurface = Color.White,
    onSurfaceVariant = LightGray,
    error = LightCoral,
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