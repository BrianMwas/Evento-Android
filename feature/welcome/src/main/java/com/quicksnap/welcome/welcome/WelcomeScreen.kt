package com.quicksnap.welcome.welcome

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import com.quicksnap.theme.EventoTheme
import com.quicksnap.welcome.welcome.navgraph.WelcomeNavGraph
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity: FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeRoot()
        }
    }
}

@Composable
fun WelcomeRoot() {
    EventoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            WelcomeNavGraph()
        }
    }
}