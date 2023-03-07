package com.quicksnap.tickets.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.qr.QrCodeProperties
import com.quicksnap.qr.QrCodeView
import com.quicksnap.theme.*
import com.quicksnap.tickets.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun TicketDetailScreen(
    ticketId: String = "",
    navigatorProvider: NavigationProvider
) {
    TicketDetailBody {
        navigatorProvider.navigateUp()
    }
}


@Composable
fun TicketDetailBody(
    goBack: () -> Unit,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
                .statusBarsPadding(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = goBack) {
                Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Go back")
            }
            Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
                Text(text = "My Ticket", style = EventoTypography.h6)
            }
        }
        Card(
            modifier = Modifier
                .weight(1f)
                .padding(top = 16.dp, bottom = 32.dp),
            backgroundColor = EventoColors.onBackground,
            shape = EventoShaped.medium
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.event_placeholder),
                    contentDescription = "Event Preview image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(
                            EventoShaped.medium
                        )

                )
                Text(
                    text = "International Jazz Festival Jakarta 2023",
                    style = EventoTypography.h4,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Column {
                        Text(text = "Name", style = EventoTypography.caption)
                        Text(
                            text = "Brian Mwangi", style = EventoTypography.body1.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Column {
                        Text(text = "Gate", style = EventoTypography.caption)
                        Text(
                            text = "A21", style = EventoTypography.body1.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Column {
                        Text(text = "Time", style = EventoTypography.caption)
                        Text(
                            text = "9pm - 12pm", style = EventoTypography.body1.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Column {
                        Text(text = "Date", style = EventoTypography.caption)
                        Text(
                            text = "30 - 31 April 2023", style = EventoTypography.body1.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "Place", style = EventoTypography.caption)
                    Text(
                        text = "Delta, Nairobi Kenya", style = EventoTypography.body1.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    shape = EventoShaped.medium,
                    backgroundColor = EventoColors.background,
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Column(
                            modifier = Modifier.weight(1f).fillMaxHeight(),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Scan this QR Code or show this ticket at the concert entrance",
                                style = EventoTypography.body1
                            )
                            Row {
                                Text(
                                    text = "Ticket ID",
                                    style = EventoTypography.caption.copy(
                                        fontWeight = FontWeight.Light,
                                        color = DarkGray
                                    ),
                                    modifier = Modifier.padding(end = 10.dp)
                                )
                                Text(text = "322312", style = EventoTypography.body1)
                            }
                        }
                        Box(modifier = Modifier.size(100.dp).clip(EventoShaped.medium)) {
                            QrCodeView(
                                content = "https://google.com",
                                qrCodeProperties = QrCodeProperties(
                                    foregroundColor = DarkGray,
                                    backgroundColor = EventoColors.onBackground
                                )
                            )
                        }
                    }
                }

                Row(modifier = Modifier.padding(top = 16.dp)) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(EventoShaped.small)
                            .background(
                                EventoColors.primaryVariant
                            )
                            ,
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Send,
                            contentDescription = "Send Ticket",
                            tint = White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    ExpandedButton(
                        background = EventoColors.primaryVariant,
                        shape = EventoShaped.medium,
                        onClick = { /*TODO*/ }) {
                        Text(
                            text = "Download Ticket", style = EventoTypography.body1.copy(
                                fontWeight = FontWeight.Black,
                                color = White
                            )
                        )
                    }
                }
            }

        }
    }
}


@Preview
@Composable
fun TicketDetailPreview() {
    TicketDetailBody(goBack = {})
}