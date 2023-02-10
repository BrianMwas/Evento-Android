package com.quicksnap.events.presentation.order_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun OrderDetailScreen(
    viewModel: OrderDetailViewModel = hiltViewModel()
) {
    Surface {
        Column {
            Text(text = "Order screen")
        }
    }
}