package com.quicksnap.authentication.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination


@Destination
@Composable
fun SignIn() {
    Surface {
        Column {
            Text(text = "Sign In page")
        }
    }
}