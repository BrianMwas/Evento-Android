package com.quicksnap.authentication.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.quicksnap.authentication.navgraph.AuthNavGraph
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph


@AuthNavGraph(start = true)
@Destination(start = true)
@Composable
fun SignUpScreen() {
    Surface {
        Column {
           Text(text = "Sign up screen") 
        }
    }
}