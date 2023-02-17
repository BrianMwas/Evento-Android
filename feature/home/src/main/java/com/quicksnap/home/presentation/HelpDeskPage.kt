package com.quicksnap.home.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksnap.eventoframework.ui.EventoTextField
import com.quicksnap.home.R
import com.quicksnap.theme.*

@Composable
fun HelpdeskScreen(
    modifier: Modifier = Modifier,
) {
    var searchQuery by remember {
        mutableStateOf("")
    }
    Box(
        modifier = modifier
            .background(EventoColors.background)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Help Desk",
                    textAlign = TextAlign.Center,
                    style = EventoTypography.h4
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 32.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Hi Brian, what kind of help do you need?",
                    style = EventoTypography.h6.copy(
                        color = Gray,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                EventoTextField(
                    modifier = Modifier
                        .clip(EventoShaped.small)
                        .background(EventoColors.onBackground),
                    value = searchQuery,
                    onChange = {
                        searchQuery = it
                    },
                    paddingStart = 16.dp,
                    placeholder = "Write your question here",
                    suffix = {
                        Icon(
                            Icons.Default.Search,
                            tint = Gray,
                            contentDescription = "Search Icon",
                            modifier = Modifier.padding(end = 12.dp)
                        )
                    },
                    cursorColor = Primary,
                    textStyle = EventoTypography.body1,
                    placeholderStyle = EventoTypography.body1
                )
                Spacer(modifier = Modifier.height(40.dp))
                SelectTopicGrid()
                FaqOptions()
            }
        }
    }
}

@Composable
fun QueryBox(title: String, @DrawableRes icon: Int) {
    Box(
        modifier = Modifier
            .size(90.dp)
            .clip(EventoShaped.medium)
            .background(
                EventoColors.onBackground
            ), contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(icon),
                contentDescription = "$title Query"
            )
            Text(text = title, style = EventoTypography.body1)
        }
    }
}

@Composable
fun SelectTopicGrid() {
    Text(
        text = "Select a help topic", style = EventoTypography.h6.copy(
            color = Gray,
            fontSize = 16.sp
        )
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 40.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        QueryBox(
            title = "General",
            icon = R.drawable.general
        )
        QueryBox(
            title = "Account",
            icon = R.drawable.account
        )
        QueryBox(
            title = "Order",
            icon = R.drawable.order
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 40.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        QueryBox(
            title = "Payment",
            icon = R.drawable.payment
        )
        QueryBox(
            title = "Reschedule",
            icon = R.drawable.reschedule_note
        )
        QueryBox(
            title = "Other",
            icon = R.drawable.other
        )
    }
}

@Composable
fun FaqOptions() {
    Text(
        text = "FAQ", style = EventoTypography.h6.copy(
            color = Gray,
            fontSize = 16.sp
        )
    )
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        backgroundColor = EventoColors.onBackground,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = EventoShaped.small
    ) {
        Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text(text = "How do I access my tickets?")
        }
    }
    Card(
        backgroundColor = EventoColors.onBackground,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = EventoShaped.small
    ) {
        Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text(text = "How do I purchase a ticket?")
        }
    }
    Card(
        backgroundColor = EventoColors.onBackground,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = EventoShaped.small
    ) {
        Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text(text = "Can I get a refund on purchase of a ticket?")
        }
    }
}

@Composable
@Preview
fun HelpDeskPreview() {
    Surface {
        HelpdeskScreen()
    }
}