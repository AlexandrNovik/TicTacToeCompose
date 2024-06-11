package com.ali.dev.tictactoe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// dark palettes
private val DarkPinkColorPalette = darkColorScheme(
    primary = pink200,
    primaryContainer = pink500,
    secondary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkGreenColorPalette = darkColorScheme(
    primary = green200,
    primaryContainer = green700,
    secondary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkPurpleColorPalette = darkColorScheme(
    primary = purple200,
    primaryContainer = purple700,
    secondary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkBlueColorPalette = darkColorScheme(
    primary = blue200,
    primaryContainer = blue700,
    secondary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkOrangeColorPalette = darkColorScheme(
    primary = orange200,
    primaryContainer = orange700,
    secondary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkRedColorPalette = darkColorScheme(
    primary = red200,
    primaryContainer = red500,
    secondary = teal200,
    surface = Color.Black
)

private val DarkYellowColorPalette = darkColorScheme(
    primary = yellow200,
    primaryContainer = yellow500,
    secondary = teal200,
    surface = Color.Black
)

private val DarkBrownColorPalette = darkColorScheme(
    primary = brown200,
    primaryContainer = brown500,
    secondary = teal200,
    surface = Color.Black
)

private val DarkGreyColorPalette = darkColorScheme(
    primary = grey200,
    primaryContainer = grey500,
    secondary = teal200,
    surface = Color.Black
)

private val DarkIndigoColorPalette = darkColorScheme(
    primary = indigo200,
    primaryContainer = indigo500,
    secondary = teal200,
    surface = Color.Black
)

// Light pallets
private val LightPinkColorPalette = lightColorScheme(
    primary = pink500,
    primaryContainer = pink700,
    secondary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightGreenColorPalette = lightColorScheme(
    primary = green500,
    primaryContainer = green700,
    secondary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightPurpleColorPalette = lightColorScheme(
    primary = purple500,
    primaryContainer = purple700,
    secondary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightBlueColorPalette = lightColorScheme(
    primary = blue500,
    primaryContainer = blue700,
    secondary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightOrangeColorPalette = lightColorScheme(
    primary = orange500,
    primaryContainer = orange700,
    secondary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightRedColorPalette = lightColorScheme(
    primary = red500,
    primaryContainer = red700,
    secondary = teal200,
    surface = Color.White
)

private val LightYellowColorPalette = lightColorScheme(
    primary = yellow500,
    primaryContainer = yellow700,
    secondary = teal200,
    surface = Color.White
)

private val LightBrownColorPalette = lightColorScheme(
    primary = brown500,
    primaryContainer = brown700,
    secondary = teal200,
    surface = Color.White
)

private val LightGreyColorPalette = lightColorScheme(
    primary = grey500,
    primaryContainer = grey700,
    secondary = teal200,
    surface = Color.White
)

private val LightIndigoColorPalette = lightColorScheme(
    primary = indigo500,
    primaryContainer = indigo700,
    secondary = teal200,
    surface = Color.White
)

enum class ColorPalette {
    PINK, PURPLE, GREEN, ORANGE, BLUE, RED, INDIGO, BROWN, GREY
}

@Composable
fun TicTacToeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    colorPalette: ColorPalette = ColorPalette.PINK,
    content: @Composable() () -> Unit
) {

    val colors = colorPalette.getMaterialColors(darkTheme)

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )


}

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

fun ColorPalette.getMaterialColors(darkTheme: Boolean): ColorScheme {
    return when (this) {
        ColorPalette.GREEN -> if (darkTheme) DarkGreenColorPalette else LightGreenColorPalette
        ColorPalette.PURPLE -> if (darkTheme) DarkPurpleColorPalette else LightPurpleColorPalette
        ColorPalette.ORANGE -> if (darkTheme) DarkOrangeColorPalette else LightOrangeColorPalette
        ColorPalette.BLUE -> if (darkTheme) DarkBlueColorPalette else LightBlueColorPalette
        ColorPalette.RED -> if (darkTheme) DarkRedColorPalette else LightRedColorPalette
        ColorPalette.PINK -> if (darkTheme) DarkPinkColorPalette else LightPinkColorPalette
        ColorPalette.INDIGO -> if (darkTheme) DarkIndigoColorPalette else LightIndigoColorPalette
        ColorPalette.BROWN -> if (darkTheme) DarkBrownColorPalette else LightBrownColorPalette
        ColorPalette.GREY -> if (darkTheme) DarkGreyColorPalette else LightGreyColorPalette
    }
}

fun ColorPalette.getMaterialColor(): Color {
    return when (this) {
        ColorPalette.GREEN -> green700
        ColorPalette.BLUE -> blue700
        ColorPalette.ORANGE -> orange700
        ColorPalette.PURPLE -> purple700
        ColorPalette.RED -> red700
        ColorPalette.PINK -> pink700
        ColorPalette.INDIGO -> indigo700
        ColorPalette.BROWN -> brown700
        ColorPalette.GREY -> grey700
    }
}