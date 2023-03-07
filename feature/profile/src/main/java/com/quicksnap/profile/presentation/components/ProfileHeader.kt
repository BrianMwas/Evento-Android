package com.quicksnap.profile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksnap.profile.R
import com.quicksnap.theme.*

@Composable
fun ProfileHeader(rainbowColorsBrush: Brush, onClick: () -> Unit) {
    Column(
        modifier = Modifier.padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.height(215.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .clip(EventoShaped.medium)
                    .align(Alignment.BottomCenter),
                backgroundColor = EventoColors.onBackground,
                shape = EventoShaped.medium,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = 32.dp,
                            top = 40.dp,
                            end = 32.dp,
                            bottom = 16.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Brian Mwangi",
                        style = EventoTypography.h5
                    )
                    Row(modifier = Modifier.padding(bottom = 24.dp)) {
                        Text(text = "developertest@gmail.com")
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            Icons.Rounded.Verified,
                            tint = Primary,
                            contentDescription = "Verified"
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 8.dp,
                                end = 8.dp,
                                bottom = 10.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Complete your profile",
                            style = EventoTypography.caption.copy(
                                color = Gray,
                                fontSize = 15.sp
                            )
                        )
                        Text(
                            text = "60/100",
                            style = EventoTypography.caption.copy(
                                color = Gray,
                                fontSize = 15.sp
                            )
                        )
                    }
                    LinearProgressIndicator(
                        0.7f,
                        color = Primary,
                        backgroundColor = EventoColors.onBackground
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .padding(5.dp),
            ) {
                Image(
                    modifier = Modifier
                        .drawBehind {
                            drawCircle(
                                rainbowColorsBrush,
                                style = Stroke(5f)
                            )
                        }
                        .size(90.dp)
                        .clip(CircleShape)
                        .align(Alignment.TopCenter),
                    painter = painterResource(id = R.drawable.profile_img),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Current logged in user profile image"
                )
                Box(modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .height(IntrinsicSize.Min)
                    .clip(CircleShape)
                    .background(White)
                    .padding(2.dp)
                    .clickable {
                        onClick()
                    }
                    .align(Alignment.TopEnd)
                ) {
                    Icon(
                        Icons.Default.PhotoCamera,
                        tint = PrimaryDark,
                        contentDescription = "Take a photo"
                    )
                }
            }
        }
    }
}