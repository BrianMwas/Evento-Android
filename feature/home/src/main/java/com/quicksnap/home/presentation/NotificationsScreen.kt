package com.quicksnap.home.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.eventoframework.ui.EmptyData
import com.quicksnap.home.R
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch

enum class NotificationType(@DrawableRes val icon: Int) {
    Welcome(R.drawable.welcome),
    Discount(R.drawable.discount),
    TicketAvailable(R.drawable.available_tickets),
    Reminder(R.drawable.reminder),
    Reschedule(R.drawable.reschedule_note),
    Thanks(R.drawable.smile)
}

@Destination
@Composable
fun NotificationScreen(
    navigationProvider: NavigationProvider,
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState) {
        NotificationBody(
            modifier = Modifier.padding(it.calculateTopPadding()),
            goBack = { navigationProvider.navigateUp() },
            onClear = {
                coroutineScope.launch {
                    when(scaffoldState.snackbarHostState.showSnackbar(message = "Clear all notifications", actionLabel = "YES")) {
                        SnackbarResult.Dismissed -> {}
                        SnackbarResult.ActionPerformed -> {}
                    }
                }
            }
        )
    }
}

@Composable
fun NotificationBody(
    modifier: Modifier = Modifier,
    goBack: () -> Unit,
    onClear: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(EventoColors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = goBack) {
                    Icon(Icons.Default.ArrowBackIosNew, tint = Gray, contentDescription = "Go back")
                }
                Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
                    Text(text = "Notification", style = EventoTypography.h5)
                }
                IconButton(onClick = onClear) {
                    Icon(Icons.Outlined.Cancel, tint = Gray, contentDescription = "Clear all notifications")
                }
            }
//            EmptyData(
//                icon = R.drawable.bell,
//                title = "No Notifications",
//                explanation = "No notifications yet. They will appear here automatically once you receive them.",
//                titleStyle = EventoTypography.h5.copy(
//                    fontWeight = FontWeight.Bold,
//                ),
//                subtitleStyle = EventoTypography.body2.copy(
//                    color = SecondaryDark
//                )
//            )
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
                    text = title, style = EventoTypography.h5.copy(
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(text = subtitle, style = EventoTypography.caption.copy(
                    color = DarkGray
                ))
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
        NotificationBody(goBack = {}, onClear = {})
    }
}