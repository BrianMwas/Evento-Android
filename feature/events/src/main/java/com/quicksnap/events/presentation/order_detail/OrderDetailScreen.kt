package com.quicksnap.events.presentation.order_detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.events.R
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.*
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun OrderDetailScreen(
    orderId: String = "",
    eventId: String = "",
    navigationProvider: NavigationProvider,
    viewModel: OrderDetailViewModel = hiltViewModel()
) {

    OrderDetailPage(
        goBack = {
            navigationProvider.navigateUp()
        },
        toEvents = {
            navigationProvider.popTillParent()
        },
        toTicket = { ticketId ->
            navigationProvider.openTicketDetail(ticketId)
        }
    )
}

@Composable
fun OrderDetailPage(goBack: () -> Unit, toTicket: (String) -> Unit, toEvents: () -> Unit) {
    var showDialog by remember {
        mutableStateOf(false)
    }

    OrderResponseDialog(
        showDialog = showDialog,
        onClose = { /*TODO*/ },
        toTicket = toTicket,
        toEvents = toEvents,
        closeDialog = {
            showDialog = false
        })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = goBack) {
                Icon(Icons.Default.ArrowBackIosNew, tint = Gray, contentDescription = "Go back")
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Detail Order", style = EventoTypography.h5)
            }
        }
        Card(
            shape = EventoShaped.medium,
            backgroundColor = EventoColors.onBackground,
            modifier = Modifier.padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.event_placeholder),
                    contentDescription = "Event preview page",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(EventoShaped.small)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "International Jazz Festival Jakarta India",
                    style = EventoTypography.h5
                )
                Text(
                    text = "21 January 2023 - Jakarta India",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text(text = "Time", style = EventoTypography.caption)
                        Text(
                            text = "9pm - 12pm", style = EventoTypography.body1
                        )
                    }
                    Column {
                        Text(text = "Gate", style = EventoTypography.caption)
                        Text(
                            text = "A21", style = EventoTypography.body2
                        )
                    }
                }
                Column {
                    Text(text = "Package", style = EventoTypography.caption)
                    Text(
                        text = "Gold Package - VIPP Seat, 2 Day Full",
                        style = EventoTypography.body1
                    )
                }
            }
        }
        Card(
            shape = EventoShaped.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 16.dp, end = 16.dp),
            backgroundColor = EventoColors.onBackground
        ) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.Start) {
                Text(text = "Order Summary", style = EventoTypography.h5)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Gold Package", style = EventoTypography.body2)
                    Text(
                        text = "$243", style = EventoTypography.body1.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Tax", style = EventoTypography.body2)
                    Text(
                        text = "$21", style = EventoTypography.body1.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Fees", style = EventoTypography.body2)
                    Text(
                        text = "$1", style = EventoTypography.body1.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    backgroundColor = DarkGray,
                    shape = EventoShaped.small
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Total", style = EventoTypography.body2)
                        Text(
                            text = "$256", style = EventoTypography.body1.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
        Card(
            shape = EventoShaped.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
            backgroundColor = EventoColors.onBackground,
        ) {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Text(text = "Payment", style = EventoTypography.h5)
                Card(
                    modifier = Modifier.padding(top = 16.dp),
                    shape = EventoShaped.small,
                    backgroundColor = DarkGray
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            modifier = Modifier.padding(start = 4.dp, end = 8.dp),
                            painter = painterResource(id = R.drawable.visa),
                            contentDescription = "Payment method"
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Visa Card Travel",
                                style = EventoTypography.body1.copy(fontWeight = FontWeight.SemiBold)
                            )
                            Text(text = "5233 4212 7255 XXXX", style = EventoTypography.caption)
                        }
                        IconButton(
                            modifier = Modifier.clip(CircleShape),
                            onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Default.ArrowForwardIos,
                                tint = LightGray,
                                contentDescription = "Change Payment method"
                            )
                        }
                    }
                }
            }
        }
        ExpandedButton(
            modifier = Modifier.padding(horizontal = 16.dp),
            background = Primary,
            shape = EventoShaped.small,
            onClick = {
                showDialog = true
            }) {
            Text(text = "Place Order")
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OrderResponseDialog(
    showDialog: Boolean,
    onClose: () -> Unit,
    toTicket: (String) -> Unit,
    toEvents: () -> Unit,
    closeDialog: () -> Unit
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = onClose, properties = DialogProperties(
                decorFitsSystemWindows = true,
                usePlatformDefaultWidth = false
            )
        ) {
            OrderResponseScreen(
                toTicket = toTicket,
                toEvents = toEvents,
                closeDialog = closeDialog,
            )
        }
    }
}

@Preview
@Composable
fun OrderDetailPagePreview() {
    Surface {
        OrderDetailPage(
            goBack = {},
            toTicket = {},
            toEvents = {},
        )
    }
}