package com.quicksnap.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable

val darkColorPalette = darkColors(
    primary = PrimaryDark,
    primaryVariant = PrimaryDark,
    onPrimary = AccentDark,
    secondary = SecondaryDark,
    secondaryVariant = AccentDark,
    onSecondary = SecondaryDark,
    background = BackgroundDark,
    onBackground = BackgroundDark,
    surface = CardBackgroundDark,
    onSurface = AccentDark
)

val lightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = Primary,
    onPrimary = Black,
    secondary = Secondary,
    secondaryVariant = TextFieldGray,
    onSecondary = Accent,
    background = BackgroundLight,
    onBackground = BackgroundLight,
    surface = CardBackgroundLight,
    onSurface = LightGray
)

val EventoColors: Colors
    @Composable get() = MaterialTheme.colors

val EventoShaped: Shapes
    @Composable get() = MaterialTheme.shapes

val EventoTypography: Typography
    @Composable get() = MaterialTheme.typography

@Composable
fun EventoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
)  {
    val colors = if(darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    val typography = if (darkTheme) {
        DarkTypography
    } else {
        LightTypography
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}