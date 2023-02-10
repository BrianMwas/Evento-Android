package com.quicksnap.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quicksnap.theme.EventoColors
import com.ramcosta.composedestinations.annotation.Destination

@Composable
fun HelpdeskScreen(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.background(EventoColors.background)) {
        Column {
            Text(text = "Help Desk")
        }
    }
}