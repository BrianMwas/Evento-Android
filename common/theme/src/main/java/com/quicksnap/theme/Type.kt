package com.quicksnap.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val DarkTypography = Typography(
    h1 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.Bold,
        color = Primary,
        fontSize = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.SemiBold,
        color = White,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = NunitoSansFonts,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 26.sp
    ),
    h4 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 15.sp
    ),
    h6 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 15.sp,
    ),
    body1 = TextStyle(
        fontFamily = NunitoSansFonts,
        fontWeight = FontWeight.Normal,
        color = LightGray,
        fontSize = 15.sp
    ),
    body2 = TextStyle(
        fontFamily = NunitoSansFonts,
        fontWeight = FontWeight.Normal,
        color = LightGray,
    ),
    button = TextStyle(
        fontFamily = NunitoSansFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 15.sp
    ),
    caption = TextStyle(
        fontFamily = NunitoSansFonts,
        fontSize = 13.sp,
        color = White,
    )
)

val LightTypography = Typography(
    h1 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.Bold,
        color = Primary,
        fontSize = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.SemiBold,
        color = Black,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = NunitoSansFonts,
        fontWeight = FontWeight.Normal,
        color = Black,
        fontSize = 26.sp
    ),
    h4 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 15.sp
    ),
    h6 = TextStyle(
        fontFamily = OpenSansFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 15.sp
    ),
    body1 = TextStyle(
        fontFamily = NunitoSansFonts,
        fontWeight = FontWeight.Normal,
        color = DarkGray,
        fontSize = 15.sp
    ),
    body2 = TextStyle(
        fontFamily = NunitoSansFonts,
        fontWeight = FontWeight.Normal,
        color = Primary,
        fontSize = 15.sp
    ),
    button = TextStyle(
        fontFamily = NunitoSansFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 15.sp
    ),
    caption = TextStyle(
        fontFamily = NunitoSansFonts,
        fontSize = 13.sp
    )
)