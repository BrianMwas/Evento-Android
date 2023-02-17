package com.quicksnap.tickets.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksnap.eventoframework.ui.EmptyData
import com.quicksnap.events.presentation.list.components.EventCard
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.*
import com.quicksnap.tickets.R
import com.quicksnap.tickets.presentation.components.UpcomingTicketCard
import java.util.*

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
    Box(
        modifier = modifier
            .background(EventoColors.background)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(top = 50.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Your Order",
                    textAlign = TextAlign.Center,
                    style = EventoTypography.h4
                )
            }
            Text(
                text = "Upcoming",
                style = EventoTypography.h6.copy(
                    color = Primary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            UpcomingTicketCard()
            UpcomingTicketCard()
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "History",
                style = EventoTypography.h6.copy(
                    color = Primary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            LazyRow(modifier = Modifier.padding(vertical = 10.dp)) {
                items(3) {
                    Box(
                        modifier = Modifier.padding(
                            start = if (it == 0) 32.dp else 4.dp,
                            end = 4.dp
                        )
                    ) {
                        EventCard(
                            eventTitle = "Food Festival Years Indo",
                            eventLocation = "Jarkata, Indonesia",
                            eventStartDate = Date(),
                            price = 45.0,
                            isHistory = true,
                            backgroundColor = EventoColors.onBackground
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun EmptyTicketsPage() {
    EmptyData(
        icon = R.drawable.empty_tickets,
        title = "There are no upcoming tickets yet",
        titleStyle = EventoTypography.h6.copy(
            fontWeight = FontWeight.Bold
        ),
        explanation = "Don't miss your chance to catch your favorite meet up",
        subtitleStyle = EventoTypography.body2.copy(
            color = SecondaryDark
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun EmptyTicketsPreview() {
    EmptyTicketsPage()
}