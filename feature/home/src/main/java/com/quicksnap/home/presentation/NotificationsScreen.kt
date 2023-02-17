package com.quicksnap.home.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.eventoframework.ui.EmptyData
import com.quicksnap.home.R
import com.quicksnap.theme.*

enum class NotificationType(@DrawableRes val icon: Int) {
    Welcome(R.drawable.welcome),
    Discount(R.drawable.discount),
    TicketAvailable(R.drawable.available_tickets),
    Reminder(R.drawable.reminder),
    Reschedule(R.drawable.reschedule_note),
    Thanks(R.drawable.smile)
}

@Composable
fun NotificationScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(EventoColors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(top = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Go back")
                }
                Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
                    Text(text = "Notification", style = EventoTypography.h5)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Outlined.Cancel, contentDescription = "Clear all notifications")
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 32.dp)
            ) {
                NotificationCard(
                    type = NotificationType.Welcome,
                    title = "Welcome to Evento",
                    subtitle = "Think more about having fun at the event and less on planning to get there"
                )
            }
        }
    }
}

@Composable
fun NotificationCard(
    type: NotificationType,
    title: String,
    subtitle: String,
) {
    Card(
        shape = EventoShaped.medium,
        backgroundColor = EventoColors.onBackground,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(painter = painterResource(id = type.icon), contentDescription = "Discount icon")
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = title, style = EventoTypography.h6.copy(
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(text = subtitle, style = EventoTypography.caption.copy(color = SecondaryDark))
            }
        }
    }
}

@Preview
@Composable
fun NotificationCardPreview() {
    EventoTheme {
        NotificationCard(
            type = NotificationType.Welcome,
            title = "Welcome to Evento",
            subtitle = "Book events at your convenience, make the most of the event you are attending."
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun EmptyNotificationsPreview() {
    EmptyData(
        icon = R.drawable.bell,
        title = "No Notifications",
        explanation = "No notifications yet. They will appear here automatically once you receive them.",
        titleStyle = EventoTypography.h6.copy(
            fontWeight = FontWeight.Bold,
        ),
        subtitleStyle = EventoTypography.body2.copy(
            color = SecondaryDark
        )
    )
}

@Preview
@Composable
fun NotificationScreenPreview() {
    EventoTheme {
        NotificationScreen()
    }
}