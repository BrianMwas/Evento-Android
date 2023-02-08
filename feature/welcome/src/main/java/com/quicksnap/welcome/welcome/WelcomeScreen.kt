package com.quicksnap.welcome.welcome

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.quicksnap.eventoframework.SetupSystemUIController
import com.quicksnap.theme.EventoColors
import com.quicksnap.theme.EventoTheme
import com.quicksnap.welcome.welcome.navgraph.WelcomeNavGraph
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity: FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WelcomeRoot()
        }
    }
}

@Composable
fun WelcomeRoot() {
    EventoTheme {
        val isDark = isSystemInDarkTheme()
        if (isDark) {
            SetupSystemUIController(rememberSystemUiController(), Color.Transparent)
        } else {
            SetupSystemUIController(rememberSystemUiController(), Color.Transparent)
        }

        Surface(modifier = Modifier.fillMaxSize()) {
            WelcomeNavGraph()
        }
    }
}