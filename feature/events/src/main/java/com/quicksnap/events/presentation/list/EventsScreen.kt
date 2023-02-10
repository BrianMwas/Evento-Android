package com.quicksnap.events.presentation.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quicksnap.eventoframework.ui.EventoTextField
import com.quicksnap.events.R
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.theme.*
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventsScreen(
    modifier: Modifier = Modifier,
    navigationProvider: NavigationProvider,
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    ),
    viewModel: EventsViewModel = hiltViewModel()
) {
    var search by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier.background(EventoColors.background)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                        .background(Primary)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Image(
                            painterResource(id = R.drawable.events_top_bg),
                            contentDescription = stringResource(
                                R.string.global_events
                            ),
                            contentScale = ContentScale.FillBounds,
                            colorFilter = ColorFilter.tint(
                                Primary.copy(alpha = 0.2f),
                                blendMode = BlendMode.Darken
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Primary.copy(alpha = 0.5f))
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .statusBarsPadding()
                            .padding(start = 32.dp, end = 32.dp, top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Welcome back \uD83D\uDC4B",
                                style = EventoTypography.caption
                            )
                            Text(text = "Brian Mwangi", style = EventoTypography.h4)
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .clip(
                                    CircleShape
                                )
                                .background(EventoColors.primaryVariant)

                        ) {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = "Notifications",
                                tint = White
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 6.dp)
                        .offset(y = (170.dp - 30.dp)),
                    contentAlignment = Alignment.Center,
                ) {
                    EventoTextField(
                        modifier = Modifier
                            .clip(EventoShaped.small)
                            .background(EventoColors.secondaryVariant)
                            .height(48.dp),
                        value = search,
                        onChange = {
                            search = it
                        },
                        paddingStart = 27.dp,
                        placeholder = "Search",
                        placeholderStyle = EventoTypography.body1.copy(
                            Gray
                        ),
                        suffix = {
                            Icon(
                                Icons.Outlined.Search,
                                contentDescription = stringResource(R.string.search_events),
                                tint = Gray,
                                modifier = Modifier.padding(end = 27.dp)
                            )
                        },

                        textStyle = EventoTypography.body1,
                        cursorColor = EventoTypography.body1.color
                    )
                }
            }
            Column(modifier = Modifier.padding(horizontal = 32.dp)) {
                Text(text = "Events list")
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Go to event details")
                }
            }
        }
    }

}