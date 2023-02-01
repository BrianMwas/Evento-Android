package com.quicksnap.welcome.welcome.authentication.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SignUpScreen(toLogin: () -> Unit) {
    Box {
        Text(text = "Sign up Screen")
        Button(onClick = toLogin) {
            Text(text = "Login")
        }
    }
}