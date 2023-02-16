package com.quicksnap.events.presentation.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.events.R
import com.quicksnap.theme.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun EventCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    eventTitle: String,
    eventStartDate: Date,
    eventLocation: String,
    price: Double,
    isHistory: Boolean = false
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .clip(EventoShaped.medium),
        backgroundColor = backgroundColor,
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.concert),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Event preview photo",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(EventoShaped.small)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(4.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.sports_soccer),
                            contentDescription = "Sports event",
                            tint = Color.Magenta
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(4.dp)
                    ) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Sports event",
                            tint = Color.Red
                        )
                    }
                }
            }
            Column(modifier = Modifier.padding(start = 5.dp, end = 5.dp, bottom = 5.dp)) {
                Text(
                    text = eventTitle,
                    style = EventoTypography.h5,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH)
                        .format(eventStartDate),
                    style = EventoTypography.body2.copy(color = Gray)
                )
                Text(
                    text = eventLocation,
                    style = EventoTypography.body2.copy(color = Gray),
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                if (isHistory) {
                    ExpandedButton(
                        modifier = Modifier.padding(top = 12.dp),
                        background = EventoColors.secondary,
                        shape = EventoShaped.small,
                        onClick = { /*TODO*/ }) {
                        Text(text = "Rebooking")
                    }
                } else {
                    Text(
                        text = "$$price",
                        style = EventoTypography.h5.copy(
                            color = Primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                }
            }
        }
    }
}

@Preview
@Composable
fun EventCardPreview() {
    EventCard(
        backgroundColor = Color.White,
        eventTitle = "The Flutter way",
        eventStartDate = Date(),
        eventLocation = "Nairobi, Kenya",
        price = 20.0,
        isHistory = true
    )
}