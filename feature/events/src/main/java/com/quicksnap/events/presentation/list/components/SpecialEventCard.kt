package com.quicksnap.events.presentation.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.sp
import com.quicksnap.events.R
import com.quicksnap.theme.*
import java.text.DateFormat
import java.util.*


@Composable
fun SpecialEventCard(
    category: String,
    title: String,
    startDate: Date,
    location: String,
    price: Double,
    discountedPrice: Double,
    backgroundColor: Color,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 5.dp)
            .height(90.dp),
        backgroundColor = backgroundColor,
        shape = EventoShaped.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 5.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.concert),
                contentDescription = "Concert image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(
                        EventoShaped.small
                    )
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = category, style = EventoTypography.caption.copy(
                        color = PrimaryVariant
                    )
                )
                Text(
                    text = title, style = EventoTypography.body1.copy(
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH)
                        .format(startDate), style = EventoTypography.caption.copy(
                        color = Gray
                    )
                )
                Text(
                    text = location, style = EventoTypography.caption.copy(
                        color = Gray
                    )
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight().padding(bottom = 5.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "$$price",
                    style = EventoTypography.body2.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.LineThrough,
                    )
                )
                Text(
                    text = "$$discountedPrice",
                    style = EventoTypography.body1.copy(
                        color = Primary,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
fun SpecialEventCardPreview() {
    SpecialEventCard(
        category = "Food",
        title = "Padong Food Festival",
        startDate = Date(),
        location = "Jarkata Indonesia",
        price = 55.0,
        discountedPrice = 35.0,
        backgroundColor = Color.White,
    )
}

@Preview
@Composable
fun SpecialEventListPreview() {
    LazyColumn {
        items(5) {
            SpecialEventCard(
                category = "Food",
                title = "Padong Food Festival",
                startDate = Date(),
                location = "Jarkata Indonesia",
                price = 55.0,
                discountedPrice = 35.0,
                backgroundColor = Color.White,
            )
        }
    }
}