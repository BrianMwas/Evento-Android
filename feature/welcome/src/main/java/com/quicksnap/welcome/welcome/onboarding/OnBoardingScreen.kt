package com.quicksnap.welcome.welcome.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksnap.theme.EventoTheme
import com.quicksnap.welcome.R

@Composable
fun OnBoardingScreen(
    toWelcomeScreen: () -> Unit,
) {
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(R.drawable.basketball_game), contentScale = ContentScale.FillHeight, contentDescription = "People playing basketball", modifier = Modifier.fillMaxSize())

        }
    }
}

@Composable
fun OnBoardingDetail() {
    Box(modifier = Modifier.height(400.dp).fillMaxWidth().background(Color.Gray)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                shadowElevation = 9.dp.toPx()
                shape = OnboardingDetailCurveShape()
                clip = true
            }
            .background(Color.White)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Onboarding title")
                Text(text = "OnBoarding Description")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OnBoardingDetail_Preview() {
    EventoTheme {
        OnBoardingDetail()
    }
}