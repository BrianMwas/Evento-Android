package com.quicksnap.profile.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksnap.theme.EventoColors
import com.quicksnap.theme.EventoShaped
import com.quicksnap.theme.EventoTypography
import com.quicksnap.theme.Gray

@Composable
fun ProfileActionCard(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes icon: Int,
    onTap: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 4.dp)
            .clickable {
                onTap()
            },
        shape = EventoShaped.medium,
        backgroundColor = EventoColors.onBackground,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(icon),
                    modifier = Modifier.padding(end = 10.dp),
                    tint = Gray,
                    contentDescription = "Edit profile data"
                )
                Text(
                    text = title, style = EventoTypography.body1.copy(
                        fontSize = 15.sp
                    )
                )
            }
            IconButton(onClick = onTap) {
                Icon(Icons.Default.ChevronRight, contentDescription = "Go")
            }
        }
    }
}