package com.quicksnap.events.presentation.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.events.R
import com.quicksnap.theme.*

@Composable
fun PopularEventCard() {
    Box(
        modifier = Modifier
            .size(300.dp, 200.dp)
            .clip(EventoShaped.medium)
            , contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.concert),
            contentDescription = "Popular event placeholder",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(White)
                            .padding(4.dp),) {
                        Icon(painterResource(id = R.drawable.sports_soccer), tint = Color.Magenta, contentDescription = "Event Category")
                    }
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(White)
                            .padding(4.dp),) {
                        Icon(Icons.Outlined.Favorite, tint = Color.Red, contentDescription = "Like Event button")
                    }
                }
                Card(
                    backgroundColor = EventoColors.onBackground,
                    shape = EventoShaped.medium
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                            .height(IntrinsicSize.Max),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier
                            .weight(1f)
                            .padding(end = 10.dp)) {
                            Text(
                                text = "International Jazz Festival",
                                style = EventoTypography.body1
                            )
                            Text(
                                text = "30 April 2023 - Nairobi Kenya",
                                style = EventoTypography.caption
                            )
                        }
                        Text(
                            text = "$234",
                            style = EventoTypography.h6.copy(color = Primary)
                        )
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
fun PopularEventCardPreview() {
    PopularEventCard()
}