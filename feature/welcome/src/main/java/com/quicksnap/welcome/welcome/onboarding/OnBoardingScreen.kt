package com.quicksnap.welcome.welcome.onboarding

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.quicksnap.theme.*
import com.quicksnap.welcome.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    toWelcomeScreen: () -> Unit,
) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    val images = arrayListOf(R.drawable.conference, R.drawable.panel, R.drawable.concert_people)
    var currentImage by remember {
        mutableStateOf(0)
    }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect {
            currentImage = it
        }
    }

    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.BottomCenter
        ) {
            Crossfade(targetState = currentImage, animationSpec = tween(durationMillis = 1000)) { current ->
                Image(
                    painter = painterResource(images[current]),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = "Evento features",
                    modifier = Modifier.fillMaxSize()
                )
            }
            OnBoardingDetail(state = pagerState, scope = scope, skip = toWelcomeScreen)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingDetail(
    modifier: Modifier = Modifier,
    state: PagerState,
    scope: CoroutineScope,
    skip: () -> Unit
) {
    Box(
        modifier = modifier
            .height(420.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                shadowElevation = 9.dp.toPx()
                shape = OnboardingDetailCurveShape()
                clip = true
            }
            .background(EventoColors.surface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 56.dp), verticalArrangement = Arrangement.Center
            ) {
                HorizontalPagerIndicator(
                    pagerState = state,
                    inactiveColor = EventoColors.secondary,
                    activeColor = Primary,
                    modifier = Modifier.padding(top = 42.dp, bottom = 16.dp, start = 44.dp)
                )
                HorizontalPager(count = 3, state = state, userScrollEnabled = false) { page ->
                    when (page) {
                        0 -> {
                            OnBoardingDetailFeature(
                                title = "Get Connected",
                                subtitle = "Create new connections easily by advertising your events at your convenience",
                                skip = skip,
                                coroutineScope = scope,
                                state = state,
                                currentPage = page,
                            )
                        }
                        1 -> {
                            OnBoardingDetailFeature(
                                title = "Explore",
                                subtitle = "Why get bored when you can show up to free events and exclusive ones.",
                                skip = skip,
                                coroutineScope = scope,
                                state = state,
                                currentPage = page,
                            )
                        }
                        else -> {
                            OnBoardingDetailFeature(
                                title = "Plan Ahead",
                                subtitle = "Organise yourself and never miss any event with on time notifications.",
                                skip = skip,
                                coroutineScope = scope,
                                state = state,
                                currentPage = page,
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingDetailFeature(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    skip: () -> Unit,
    coroutineScope: CoroutineScope,
    state: PagerState,
    currentPage: Int,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 42.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = title, style = EventoTypography.h2.copy(color = Primary, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = subtitle,
            style = EventoTypography.body1
        )
        Row(
            modifier = Modifier
                .padding(top = 56.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = skip) {
                Text(
                    text = "SKIP",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.Light,
                        color = EventoColors.secondary
                    )
                )
            }
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Primary),
                onClick = {
                    coroutineScope.launch {
                        if (state.canScrollForward) {
                            state.scrollToPage(currentPage + 1)
                        } else {
                            skip.invoke()
                        }
                    }
                }) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Forward", tint = White)
            }
        }
    }

}

