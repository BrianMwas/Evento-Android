package com.quicksnap.events.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun OrderScreen() {
    Surface {
        Column {
            Text(text = "Order screen")
        }
    }
}