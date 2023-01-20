package com.quicksnap.authentication.forgot_password

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun ForgotPasswordScreen() {
    Surface {
        Column {
            Text(text = "ForgotPassword")
        }
    }
}