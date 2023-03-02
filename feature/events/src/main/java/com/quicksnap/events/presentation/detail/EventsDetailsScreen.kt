package com.quicksnap.events.presentation.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.events.R
import com.quicksnap.events.navgraph.EventsNavGraph
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.*
import com.ramcosta.composedestinations.annotation.Destination

@EventsNavGraph(start = true)
@Destination(start = true)
@Composable
fun EventDetailsScreen(
    id: String = "",
    navigator: NavigationProvider,
    viewModel: EventDetailViewModel = hiltViewModel()
) {
    EventBody(goBack = { navigator.navigateUp() }, toOrderDetail = {
        navigator.openOrderDetail("event_id", "order_id")
    })
}

@Composable
fun EventBody(goBack: () -> Unit, toOrderDetail: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            Image(
                painter = painterResource(id = R.drawable.event_placeholder),
                contentDescription = "Concert detail image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp).fillMaxWidth()
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            shape = EventoShaped.large,
        ) {
            Column(modifier = Modifier.padding(horizontal = 32.dp, vertical = 24.dp)) {
                Column(modifier = Modifier.weight(0.75f)) {
                    Text(
                        text = "International Jazz Festival Jakarta 2023",
                        style = EventoTypography.h4
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 16.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Event,
                                contentDescription = "Calendar",
                                tint = EventoColors.onSecondary,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Text(text = "30 - 31 April 2023")
                        }
                        Spacer(modifier = Modifier.width(40.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Schedule,
                                contentDescription = "Calendar",
                                tint = EventoColors.onSecondary,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Text(text = "9pm - 12pm")
                        }
                    }
                    Row(
                        modifier = Modifier.padding(bottom = 32.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.PinDrop,
                            contentDescription = "Calendar",
                            tint = EventoColors.onSecondary,
                            modifier = Modifier.padding(end = 10.dp)
                        )
                        Text(text = "Nairobi,  Kenya")
                    }
                    Text(
                        text = "Description",
                        style = EventoTypography.h6.copy(
                            fontSize = EventoTypography.body1.fontSize,
                            color = EventoColors.onSecondary
                        ),
                        modifier = Modifier.padding(bottom = 8.dp),
                    )
                    Text(text = "You are responsible for operations, service, or customer support and face challenges trying to communicate complex procedures to a global market effectively.")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Package",
                        style = EventoTypography.h6.copy(
                            fontSize = EventoTypography.body1.fontSize,
                            color = EventoColors.onSecondary
                        ),
                        modifier = Modifier.padding(bottom = 8.dp),
                    )
                    CardPackage(modifier = Modifier.padding(bottom = 8.dp))
                    CardPackage(isSelected = true, important = false)
                }
                Box(modifier = Modifier.weight(0.25f), contentAlignment = Alignment.BottomCenter) {
                    ExpandedButton(
                        background = Primary,
                        shape = EventoShaped.medium,
                        onClick = toOrderDetail
                    ) {
                        Text(
                            text = "Book Now", style = EventoTypography.body2.copy(
                                fontWeight = FontWeight.Bold,
                                color = White
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CardPackage(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    important: Boolean = true
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        border = if (isSelected) BorderStroke(2.dp, Primary) else null,
        shape = EventoShaped.medium,
        backgroundColor = EventoColors.onBackground
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(EventoShaped.medium)
                    .background(
                        if (important) Amber else LightGray
                    ), contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Star, contentDescription = "Star", tint = White)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = if (important) "Gold Package" else "Silver Package",
                    style = EventoTypography.h6.copy(
                        fontSize = EventoTypography.body2.fontSize,
                        color = EventoColors.onSecondary
                    )
                )
                Text(text = "VIPP Seat, 2 Day Full")
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "$355", style = EventoTypography.caption.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    textDecoration = TextDecoration.LineThrough
                )
                Text(
                    text = "$235", style = EventoTypography.body1.copy(
                        color = Primary,
                        fontWeight = FontWeight.Black
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun EventDetailScreen() {
    EventBody(
        toOrderDetail = {},
        goBack = {}
    )
}