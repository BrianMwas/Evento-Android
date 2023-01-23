package com.quicksnap.evento.navigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quicksnap.evento.ui.theme.EventoTheme
import com.quicksnap.home.presentation.Home
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var backPressed = 0L

    private val finish: () -> Unit = {
        if (backPressed + 3000L > System.currentTimeMillis()) {
            finishAndRemoveTask()
        } else {
            Toast.makeText(this, "Long press to exit the app", Toast.LENGTH_SHORT).show()
        }
        backPressed = System.currentTimeMillis()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainRoot(finish = finish)
        }
    }
}
