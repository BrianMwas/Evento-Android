package com.quicksnap.welcome.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph



@Composable
fun WelcomeScreen() {
    Surface {
        Column {
            Text(text = "Welcome to Evento")
        }
    }
}