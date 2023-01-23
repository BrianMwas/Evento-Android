package com.quicksnap.welcome.welcome.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun OnBoardingScreen(
    toWelcomeScreen: () -> Unit,
) {
    Surface {
        Column {
            Text(text = "On boarding screen")
            Button(onClick = toWelcomeScreen) {
                Text(text = "Welcome home")
            }
        }
    }
}