package com.quicksnap.profile.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.eventoframework.ui.EventoTextField
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.profile.R
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun ChangeProfileDataScreen(navigationProvider: NavigationProvider) {
    ChangeProfileDataBody(goBack = {
        navigationProvider.navigateUp()
    })
}

@Composable
fun ChangeProfileDataBody(goBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Primary)
                .statusBarsPadding(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.profile_background),
                contentScale = ContentScale.Crop,
                contentDescription = "Profile background"
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Primary.copy(0.5f))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(start = 32.dp, end = 32.dp, top = 16.dp)
                    .align(Alignment.TopCenter),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                        .background(White)
                        .padding(5.dp)
                        .clickable { goBack() },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        Icons.Default.ArrowBackIosNew,
                        contentDescription = "Go back",
                        tint = Black
                    )
                }

                Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Change Profile", style = EventoTypography.h6.copy(
                            color = White
                        )
                    )
                }
            }
        }
        Column(modifier = Modifier
            .weight(1f)
            .padding(horizontal = 32.dp, vertical = 16.dp)) {
            EventoTextField(
                modifier = Modifier
                    .clip(EventoShaped.small)
                    .background(EventoColors.secondaryVariant),
                value = "",
                onChange = {},
                paddingStart = 16.dp,
                suffix = {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = LightGray,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                },
                placeholder = "Your name",
                placeholderStyle = EventoTypography.body2,
                textStyle = EventoTypography.body2,
                cursorColor = Primary,
            )
            EventoTextField(
                modifier = Modifier
                    .clip(EventoShaped.small)
                    .background(EventoColors.secondaryVariant),
                value = "",
                onChange = {},
                paddingStart = 16.dp,
                suffix = {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = LightGray,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                },
                placeholder = "Email",
                placeholderStyle = EventoTypography.body2,
                textStyle = EventoTypography.body2,
                cursorColor = Primary,
            )
            EventoTextField(
                modifier = Modifier
                    .clip(EventoShaped.small)
                    .background(EventoColors.secondaryVariant),
                value = "",
                onChange = {},
                paddingStart = 16.dp,
                suffix = {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = LightGray,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                },
                placeholder = "Phone Number",
                placeholderStyle = EventoTypography.body2,
                textStyle = EventoTypography.body2,
                cursorColor = Primary,
            )
            EventoTextField(
                modifier = Modifier
                    .clip(EventoShaped.small)
                    .background(EventoColors.secondaryVariant),
                value = "",
                onChange = {},
                paddingStart = 16.dp,
                suffix = {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = LightGray,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                },
                placeholder = "About",
                placeholderStyle = EventoTypography.body2,
                textStyle = EventoTypography.body2,
                cursorColor = Primary,
            )
            Spacer(modifier = Modifier.height(32.dp))
            ExpandedButton(
                background = Primary,
                shape = EventoShaped.medium,
                onClick = { /*TODO*/ }) {
                Text(text = "Save")
            }
            // We can Add Interests to someones profile
        }
    }
}

@Preview
@Composable
fun ChangeProfilePagePreview() {
    ChangeProfileDataBody(goBack = {})
}