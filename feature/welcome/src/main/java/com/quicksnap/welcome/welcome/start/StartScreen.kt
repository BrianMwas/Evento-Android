package com.quicksnap.welcome.welcome.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksnap.eventoframework.LinkableString
import com.quicksnap.theme.*
import com.quicksnap.welcome.R
import com.quicksnap.welcome.welcome.onboarding.OnboardingDetailCurveShape

@Composable
fun StartScreen(
    toLogin: () -> Unit,
    toSignUp: () -> Unit,
) {
    Surface {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Image(
                painter = painterResource(id = R.drawable.concert),
                contentDescription = "Welcome page background image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )
            WelcomeActionPane(
                toLogin = toLogin,
                toSignUp = toSignUp
            )
        }
    }
}

@Composable
fun WelcomeActionPane(
    toLogin: () -> Unit,
    toSignUp: () -> Unit,
) {
    Box(
        modifier = Modifier
            .height(420.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    shadowElevation = 9.dp.toPx()
                    clip = true
                    shape = OnboardingDetailCurveShape()
                }
                .background(EventoColors.surface),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Welcome",
                    textAlign = TextAlign.Center,
                    style = EventoTypography.h4,
                    modifier = Modifier.padding(top = 56.dp)
                )
                Text(
                    text = "Evento",
                    textAlign = TextAlign.Center,
                    style = EventoTypography.h1.copy(
                        fontSize = 32.sp,
                        fontFamily = FontFamily(
                            Font(R.font.kanit_semibold, FontWeight.SemiBold)
                        )
                    ),
                )
                Text(text = "Discover events around you", textAlign = TextAlign.Center, style = EventoTypography.body2,)
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 52.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Primary,
                        contentColor = Color.White,
                        disabledBackgroundColor = PrimaryDark
                    ),
                    contentPadding = PaddingValues(vertical = 12.dp),
                    onClick = toSignUp,
                ) {
                    Text(text = "Sign Up")
                }
                LinkableString(
                    modifier = Modifier.padding(top = 16.dp),
                    appendString = "Already a Member? ",
                    pushString = "Login",
                    onClick = toLogin,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    EventoTheme {
        StartScreen(toLogin = {}, toSignUp = {})
    }
}