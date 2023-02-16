package com.quicksnap.welcome.welcome.authentication.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.quicksnap.theme.EventoColors
import com.quicksnap.theme.EventoShaped
import com.quicksnap.theme.Gray
import com.quicksnap.welcome.R

@Composable
fun SocialAuth(
    title: String = "Or Continue with"
) {
    Text(
        text = title,
        modifier = Modifier.padding(vertical = 20.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(50.dp)
                .clip(EventoShaped.small)
                .background(
                    EventoColors.secondaryVariant
                )
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook login",
                tint = Gray
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(50.dp)
                .clip(EventoShaped.small)
                .background(
                    EventoColors.secondaryVariant
                )
                .padding(horizontal = 5.dp, vertical = 5.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.google),
                contentDescription = "Google login",
                tint = Gray
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(50.dp)
                .clip(EventoShaped.small)
                .background(
                    EventoColors.secondaryVariant
                )
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.twitter),
                contentDescription = "Twitter login",
                tint = Gray
            )
        }
    }
}