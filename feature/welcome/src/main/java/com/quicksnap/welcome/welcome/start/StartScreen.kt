package com.quicksnap.welcome.welcome.start

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quicksnap.theme.EventoTheme

@Composable
fun StartScreen() {
    Surface {
        Column {
            Text(text = "Hello World")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    EventoTheme {
        StartScreen()
    }
}