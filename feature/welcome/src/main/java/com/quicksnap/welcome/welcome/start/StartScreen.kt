package com.quicksnap.welcome.welcome.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.theme.CardBackgroundDark
import com.quicksnap.theme.CardBackgroundLight
import com.quicksnap.theme.EventoTheme

@Composable
fun StartScreen() {
    Surface {
        Column {
            Card(modifier = Modifier.padding(16.dp), backgroundColor = CardBackgroundDark) {
                Text(text = "Hello World amazing nice")
            }
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