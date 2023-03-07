package com.quicksnap.tickets.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksnap.qr.QrCodeProperties
import com.quicksnap.qr.QrCodeView
import com.quicksnap.theme.*
import java.text.DateFormat
import java.util.*

@Composable
fun UpcomingTicketCard() {
    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(start = 32.dp, end = 32.dp, bottom = 16.dp),
        backgroundColor = EventoColors.onBackground
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1.5f).padding(12.dp)) {
                Text(text = "ID 23451223 | SEAT 23", style = EventoTypography.caption.copy(
                    fontSize = 12.sp,
                    color = EventoTypography.body2.color
                ))
                Text(
                    text = "Padong Food Festival", style = EventoTypography.body2.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH)
                        .format(Date()), style = EventoTypography.caption.copy(
                        color = Gray,
                        fontSize = 12.sp,
                    )
                )
                Text(
                    text = "Jakarta, Indonesia", style = EventoTypography.caption.copy(
                        color = Gray,
                        fontSize = 12.sp,
                    )
                )
            }
            QrCodeView(
                content = "https://devbrian.dev.app",
                modifier = Modifier
                    .size(80.dp)
                    .clip(EventoShaped.medium),
                qrCodeProperties = QrCodeProperties(
                        foregroundColor = Gray,
                    backgroundColor = EventoColors.onBackground
                )
            )
        }
    }
}

@Preview
@Composable
fun UpcomingTicketCardPreview() {
    Box(modifier = Modifier.fillMaxWidth().height(120.dp).background(Color.White)) {
        UpcomingTicketCard()
    }

}