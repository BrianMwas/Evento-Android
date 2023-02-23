package com.quicksnap.eventoframework.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EmptyData(
    @DrawableRes icon: Int,
    title: String,
    titleStyle: TextStyle,
    explanation: String,
    subtitleStyle: TextStyle,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.padding(bottom = 32.dp)) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Notification Bell",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(200.dp)
            )
        }
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = titleStyle,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(modifier = Modifier.width(300.dp)) {
            Text(
                text = explanation,
                textAlign = TextAlign.Center,
                style = subtitleStyle
            )
        }
    }
}