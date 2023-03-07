package com.quicksnap.welcome.welcome.authentication.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quicksnap.eventoframework.LinkableString
import com.quicksnap.framework.extension.getActivity
import com.quicksnap.framework.extension.launchActivity
import com.quicksnap.theme.EventoColors
import com.quicksnap.theme.EventoTypography
import com.quicksnap.theme.Primary
import com.quicksnap.welcome.R
import com.quicksnap.welcome.welcome.authentication.AuthenticationEvent
import com.quicksnap.welcome.welcome.authentication.AuthenticationViewModel
import com.quicksnap.welcome.welcome.authentication.common.SocialAuth
import com.quicksnap.welcome.welcome.authentication.login.components.LoginForm
import com.quicksnap.welcome.welcome.onboarding.TrapeziumShape

@Composable
fun LoginScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    toSignUp: () -> Unit,
) {
    val authState by viewModel.authState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.isSuccess) {
        if (authState.isSuccess != null && authState.isSuccess!!) {
            context.getActivity()?.run {
                launchActivity(
                    packageName = context.packageName,
                    className = "com.quicksnap.evento.navigation.MainActivity",
                ).also {
                    finish()
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "List of past events",
            modifier = Modifier
                .fillMaxSize()
                .background(EventoColors.secondaryVariant),
            contentScale = ContentScale.FillHeight
        )
        BoxWithConstraints {
            val boxWithConstraintsScope = this

            // Calculate the height as per the current height
            val calcHeight = if (boxWithConstraintsScope.maxHeight.value <= 800)
                (boxWithConstraintsScope.constraints.maxHeight * 0.35).dp
            else
                (boxWithConstraintsScope.constraints.maxHeight * 0.25).dp


            Box(
                modifier = Modifier
                    .height(calcHeight)
                    .fillMaxWidth()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            shadowElevation = 9.dp.toPx()
                            clip = true
                            shape = TrapeziumShape()
                        }
                        .background(EventoColors.surface),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(bottom = 50.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 33.dp),
                            text = "Login", style = EventoTypography.h4.copy(
                                fontWeight = FontWeight.Normal,
                                fontSize = 22.sp
                            )
                        )
                        LoginForm(
                            authenticationState = authState,
                            handleEvent = viewModel::handleEvent,
                            forgotPassword = {
                                Log.d("FORGOT_PASSWORD", "Forgot password")
                            }
                        )
                        SocialAuth()
                        LinkableString(
                            modifier = Modifier.padding(top = 40.dp),
                            appendString = "Not a member?  ",
                            pushString = "Sign Up",
                            appendColor = Primary,
                            clickableTextColor = Primary,
                            onClick = {
                                viewModel.handleEvent(AuthenticationEvent.ToggleAuthenticationMode)
                                toSignUp()
                            }
                        )
                    }
                }
            }
        }
    }
}

