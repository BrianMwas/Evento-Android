package com.quicksnap.tickets.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun TicketDetailScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(text = "Ticket detail")
            Text(text = "Screen")
        }
    }
}