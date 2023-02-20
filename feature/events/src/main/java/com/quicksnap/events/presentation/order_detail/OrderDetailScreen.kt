package com.quicksnap.events.presentation.order_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quicksnap.events.R
import com.quicksnap.theme.EventoShaped
import com.quicksnap.theme.EventoTypography
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun OrderDetailScreen(
    viewModel: OrderDetailViewModel = hiltViewModel()
) {
    OrderDetailPage()
}

@Composable
fun OrderDetailPage() {
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Go back")
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Detail Order", style = EventoTypography.h6)
            }
        }
        Card(shape = EventoShaped.large, modifier = Modifier.padding(bottom = 8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.concert),
                    contentDescription = "Event preview page",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .clip(EventoShaped.medium)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "International Jazz Festival Jakarta India",
                    style = EventoTypography.h6.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    text = "21 January 2023 - Jakarta India",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text(text = "Time")
                        Text(
                            text = "9pm - 12pm", style = EventoTypography.h6.copy(
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                    Column {
                        Text(text = "Gate")
                        Text(
                            text = "A21", style = EventoTypography.h6.copy(
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                }
                Column {
                    Text(text = "Package")
                    Text(
                        text = "Gold Package - VIPP Seat, 2 Day Full", style = EventoTypography.body1
                    )
                }
            }
        }
        Card(shape = EventoShaped.large, modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
            Text(text = "Order Summary", style = EventoTypography.h6)

        }
    }
}

@Preview
@Composable
fun OrderDetailPagePreview() {
    Surface {
        OrderDetailPage()
    }
}