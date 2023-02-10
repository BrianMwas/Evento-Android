package com.quicksnap.tickets.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.EventoColors
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TicketListScreen(
    modifier: Modifier = Modifier,
    navigationProvider: NavigationProvider,
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.Expanded },
        skipHalfExpanded = true
        ),
) {
    Box(modifier = modifier.background(EventoColors.background)) {
        Column {
            Text(text = "Tickets")
        }
    }
}