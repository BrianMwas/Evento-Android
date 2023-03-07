package com.quicksnap.welcome.welcome.authentication.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.quicksnap.theme.*
import com.quicksnap.welcome.R
import com.quicksnap.welcome.welcome.authentication.AuthenticationEvent
import com.quicksnap.welcome.welcome.authentication.AuthenticationMode
import com.quicksnap.welcome.welcome.authentication.AuthenticationViewModel
import com.quicksnap.welcome.welcome.authentication.common.SocialAuth
import com.quicksnap.welcome.welcome.authentication.signup.components.SignupForm
import com.quicksnap.welcome.welcome.onboarding.TrapeziumShape

@Composable
fun SignUpScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    toLogin: () -> Unit,
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
                (boxWithConstraintsScope.constraints.maxHeight * 0.37).dp
            else
                (boxWithConstraintsScope.constraints.maxHeight * 0.27).dp

            Box(
                modifier = Modifier
                    .height(calcHeight)
                    .fillMaxWidth()
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        shadowElevation = 9.dp.toPx()
                        clip = true
                        shape = TrapeziumShape()
                    }
                    .background(EventoColors.surface),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(bottom = 50.dp)
                      ) {
                        Text(
                            modifier = Modifier.padding(bottom = 33.dp),
                            text = "Sign Up",
                            style = EventoTypography.h4.copy(
                                fontWeight = FontWeight.Normal,
                                fontSize = 22.sp
                            )
                        )
                        SignupForm(
                            authenticationState = authState,
                            handleEvent = viewModel::handleEvent
                        )
                        SocialAuth(
                            title = "Or Continue Sign up with"
                        )
                        LinkableString(
                            modifier = Modifier.padding(top = 40.dp),
                            appendString = "Not a member?  ",
                            pushString = "Log In",
                            appendColor = Primary,
                            clickableTextColor = Primary,
                            onClick = {
                                viewModel.handleEvent(AuthenticationEvent.ToggleAuthenticationMode)
                                toLogin()
                            }
                        )
                    }
                }
            }
        }
    }
}