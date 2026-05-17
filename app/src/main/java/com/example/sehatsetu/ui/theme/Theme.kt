package com.example.sehatsetu.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(

    primary = Color(0xFF4A90E2),

    secondary = Color(0xFF50C9C3),

    background = Color(0xFFF5F7FA),

    surface = Color.White
)

private val DarkColors = darkColorScheme(

    primary = Color(0xFF4A90E2),

    secondary = Color(0xFF50C9C3),

    background = Color(0xFF121212),

    surface = Color(0xFF1E1E1E)
)

@Composable
fun SehatSetuTheme(

    darkTheme: Boolean =
        isSystemInDarkTheme(),

    content: @Composable () -> Unit
) {

    val colors =

        if (darkTheme)
            DarkColors
        else
            LightColors

    MaterialTheme(

        colorScheme = colors,

        content = content
    )
}