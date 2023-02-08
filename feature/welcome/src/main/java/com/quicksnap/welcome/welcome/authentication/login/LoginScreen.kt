package com.quicksnap.welcome.welcome.authentication.login

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(toSignUp: () -> Unit) {
    Box {
        Text(text = "Login Screen")
        Button(onClick = toSignUp) {
            Text(text = "Sign Up")
        }
    }
}