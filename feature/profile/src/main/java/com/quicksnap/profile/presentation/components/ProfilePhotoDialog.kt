package com.quicksnap.profile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.theme.*


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfilePhotoDialog(rainbowBrush: Brush, showDialog: Boolean, onBrowse: () -> Unit, onClose: () -> Unit) {
    if (showDialog) {
        Dialog(
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ),
            onDismissRequest = onClose
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center,
            ) {
                Card(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .width(300.dp)
                        .clip(
                            EventoShaped.medium
                        )
                        .background(EventoColors.onBackground)
                        .align(Alignment.Center)
                ) {
                    Column(
                        modifier = Modifier.padding(
                            horizontal = 32.dp,
                            vertical = 16.dp
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Change Profile image", style = EventoTypography.body1.copy(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                        Image(
                            modifier = Modifier
                                .drawBehind {
                                    drawCircle(
                                        rainbowBrush,
                                        style = Stroke(10f)
                                    )
                                }
                                .size(150.dp)
                                .clip(CircleShape),
                            painter = painterResource(com.quicksnap.profile.R.drawable.profile_img),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Profile image"
                        )
                        ExpandedButton(
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                            onClick = onBrowse,
                            shape = EventoShaped.medium,
                            background = DarkGray
                        ) {
                            Text(text = "Browse")
                        }
                        ExpandedButton(
                            modifier = Modifier.padding(bottom = 16.dp),
                            onClick = onClose,
                            shape = EventoShaped.medium,
                            background = Primary
                        ) {
                            Text(text = "Save Picture")
                        }
                    }
                }

            }
        }
    }
}