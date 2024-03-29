package com.quicksnap.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BackgroundLight = Color(0xFFF6F6F6)
val BackgroundDark = Color(0xFF000000)
val Black = Color(0xFF000000)
val Gray = Color(0xFFD1D3D4)
val IconGray = Color(0xFF838383)
val PlaceholderGray = Color(0xFFC8C8C9)
val TextFieldGray = Color(0xFFF7F8FB)
val White = Color(0xFFFFFFFF)
val DarkGray = Color(0XFF656565)
val LightGray = Color(0xFFD9D9D9)

val Primary = Color(0XFF249781)
val PrimaryLight = Color(0xFFDAF5F1)
val Secondary = Color(0xFF8BDDCD)
val Accent = Color(0xFF8BDDCD)
val Amber = Color(0xFFFFC35D)

val PrimaryDark = Color(0xFF121933)
val SecondaryDark = Color(0xFF495270)
val AccentDark = Color(0xFF172F53)
val PrimaryVariant = Color(0xFF00B69C);

val Danger = Color(0xFFFF313D)
val Warning = Color(0xFFFFA141)
val Success = Color(0xFF00A3B8)

val selectedBottomNavItemColor = Primary
val unselectedBottomNavItemColorLight = Gray
val unselectedBottomNavItemColorDark = SecondaryDark

val navigationBackIconDark = Black
val navigationBackIconLight = White

val CardBackgroundLight = White
val CardBackgroundDark = PrimaryDark

//val Color.navigationBackIconColor
//    @Composable get() = if (isLight) Black else White
//
//val Color.backgroundColor
//    @Composable get() = if (isLight) BackgroundLight else BackgroundDark
//
val Color.Companion.cardBackground
    @Composable get() = if (!isSystemInDarkTheme()) CardBackgroundLight else CardBackgroundDark
//
//val Color.unselectedIconColor
//    @Composable get() = if (isLight) unselectedBottomNavItemColorDark else White

