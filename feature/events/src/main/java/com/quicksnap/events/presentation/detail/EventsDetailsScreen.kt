package com.quicksnap.events.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.quicksnap.events.navgraph.EventsNavGraph
import com.quicksnap.events.presentation.detail.EventDetailViewModel
import com.quicksnap.provider.NavigationProvider
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@EventsNavGraph(start = true)
@Destination(start = true)
@Composable
fun EventDetailsScreen(
    navigator: NavigationProvider,
    viewModel: EventDetailViewModel = hiltViewModel()
) {
    Surface {
        Column {
            Text(text = "Event details screen")
            Button(onClick = { navigator.openNotifications() }) {
                
            }
        }
    }
}