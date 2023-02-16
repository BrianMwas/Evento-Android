package com.quicksnap.profile.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksnap.profile.R
import com.quicksnap.profile.presentation.components.ProfileActionCard
import com.quicksnap.profile.presentation.components.ProfileHeader
import com.quicksnap.profile.presentation.components.ProfilePhotoDialog
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigationProvider: NavigationProvider,
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    ),
) {
    ProfilePage(modifier = modifier, sheetState = bottomSheetState)
}

enum class ThemeMode {
    System, Dark, Light
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfilePage(modifier: Modifier = Modifier, sheetState: ModalBottomSheetState) {
    val coroutineScope = rememberCoroutineScope()
    var currentTheme by remember {
        mutableStateOf(ThemeMode.Dark)
    }
    var showProfileDialog by remember {
        mutableStateOf(false)
    }

    val rainbowColorsBrush =
        Brush.horizontalGradient(listOf(Color.Magenta, Color.Yellow, Color.Green))

    ProfilePhotoDialog(
        showDialog = showProfileDialog,
        rainbowBrush = rainbowColorsBrush,
        onBrowse = {},
        onClose = {
            showProfileDialog = false
        })

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetBackgroundColor = EventoColors.onBackground,
        sheetContent = {
            Column(modifier = Modifier.padding(vertical = 16.dp)) {
                Text(
                    text = "Change theme", style = EventoTypography.h6.copy(
                        color = Gray
                    ), modifier = Modifier.padding(horizontal = 32.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Dark Mode", style = EventoTypography.body1)
                    Switch(
                        checked = currentTheme == ThemeMode.Dark, onCheckedChange = {
                            currentTheme = ThemeMode.Dark
                        },
                        colors = SwitchDefaults.colors(
                            checkedTrackColor = Primary,
                            uncheckedTrackColor = LightGray
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Light Mode", style = EventoTypography.body1)
                    Switch(
                        checked = currentTheme == ThemeMode.Light, onCheckedChange = {
                            currentTheme = ThemeMode.Light
                        }, colors = SwitchDefaults.colors(
                            checkedTrackColor = Primary,
                            uncheckedTrackColor = LightGray
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp, bottom = 52.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "System Mode", style = EventoTypography.body1)
                    Switch(
                        checked = currentTheme == ThemeMode.System, onCheckedChange = {
                            currentTheme = ThemeMode.System
                        }, colors = SwitchDefaults.colors(
                            checkedTrackColor = Primary,
                            uncheckedTrackColor = LightGray
                        )
                    )
                }
            }
        }) {
        Box(
            modifier = modifier
                .background(EventoColors.background)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Primary)
                    .offset(0.dp, 0.dp),
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
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Box(
                        modifier = Modifier
                            .offset(0.dp, 50.dp)
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Account",
                                textAlign = TextAlign.Center,
                                style = EventoTypography.h6.copy(
                                    color = White,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Transparent)
                                    .padding(horizontal = 32.dp)
                            ) {
                                ProfileHeader(
                                    rainbowColorsBrush = rainbowColorsBrush,
                                    onClick = {
                                        showProfileDialog = true
                                    })
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            ProfileActionCard(
                                title = "Change Profile Data",
                                icon = R.drawable.profile_edit,
                                onTap = {})
                            ProfileActionCard(
                                title = "Change Password",
                                icon = R.drawable.password_change,
                                onTap = {})
                            ProfileActionCard(
                                title = "Dark Mode",
                                icon = R.drawable.theme_mode,
                                onTap = {
                                    coroutineScope.launch {
                                        if (sheetState.isVisible) {
                                            sheetState.hide()
                                        } else {
                                            sheetState.show()
                                        }
                                    }
                                })
                            ProfileActionCard(
                                title = "Terms and conditions",
                                icon = R.drawable.terms_and_conditions,
                                onTap = {})
                            ProfileActionCard(
                                title = "Privacy Policy",
                                icon = R.drawable.privacy_policy,
                                onTap = {})
                            ProfileActionCard(
                                title = "Log out",
                                icon = R.drawable.logout,
                                onTap = {})
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ProfileScreenPreview() {
    ProfilePage(
        sheetState = rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
            skipHalfExpanded = true
        ),
    )
}