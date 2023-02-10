package com.quicksnap.profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.EventoColors
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigationProvider: NavigationProvider,
) {
    Box(modifier = modifier.background(EventoColors.background)) {
        Column {
            Text(text = "Profile screen")
        }
    }
}