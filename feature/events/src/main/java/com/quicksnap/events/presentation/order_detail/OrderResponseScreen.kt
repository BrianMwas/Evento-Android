package com.quicksnap.events.presentation.order_detail

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.events.R
import com.quicksnap.theme.*

@Composable
fun OrderResponseScreen(
    modifier: Modifier = Modifier,
    toTicket: (String) -> Unit,
    toEvents: () -> Unit,
    closeDialog: () -> Unit
) {
    OrderResponseBody(
        modifier = modifier.statusBarsPadding(),
        toEvents = toEvents,
        toTicket = toTicket,
        closeDialog = closeDialog
    )
}


@Composable
fun OrderResponseBody(
    modifier: Modifier = Modifier,
    toTicket: (String) -> Unit,
    toEvents: () -> Unit,
    closeDialog: () -> Unit,
): Unit {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(EventoColors.onBackground)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 32.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(Gray)
                .padding(5.dp)
                .clickable { closeDialog() }) {
                Icon(
                    Icons.Default.Close,
                    tint = Black,
                    contentDescription = "Close"
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.success_purchase),
                contentDescription = "Successful Order image",
                modifier = Modifier
                    .size(240.dp)
                    .padding(bottom = 32.dp)
            )
            Text(
                text = "Order successful",
                textAlign = TextAlign.Center,
                style = EventoTypography.h3.copy(
                    color = Primary
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Your Payment is successful\nPlease check your ticket",
                textAlign = TextAlign.Center
            )
            ExpandedButton(
                modifier = Modifier.padding(top = 32.dp),
                background = PrimaryLight, shape = EventoShaped.small, onClick = {
                    toTicket("ticket_id")
                }) {
                Text(
                    text = "View Ticket", style = EventoTypography.body1.copy(
                        color = Primary
                    )
                )
            }
            ExpandedButton(
                modifier = Modifier.padding(top = 16.dp),
                background = EventoColors.onBackground,
                shape = EventoShaped.small,
                onClick = toEvents
            ) {
                Text(
                    text = "Back Home", style = EventoTypography.body1.copy(
                        color = Gray
                    )
                )
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OrderResponseBodyPreview() {
    OrderResponseBody(
        toTicket = {},
        toEvents = {},
        closeDialog = {}
    )
}
