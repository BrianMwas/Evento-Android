package com.quicksnap.welcome.welcome.authentication.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quicksnap.eventoframework.LinkableString
import com.quicksnap.theme.*
import com.quicksnap.welcome.R
import com.quicksnap.welcome.welcome.authentication.AuthenticationViewModel
import com.quicksnap.welcome.welcome.authentication.login.components.LoginForm
import com.quicksnap.welcome.welcome.onboarding.OnboardingDetailCurveShape

@Composable
fun LoginScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    toSignUp: () -> Unit
) {
    val authState by viewModel.authState.collectAsState()

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
                (boxWithConstraintsScope.constraints.maxHeight * 0.45).dp
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
                            shape = OnboardingDetailCurveShape()
                        }
                        .background(EventoColors.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(vertical = 10.dp)
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
                        Text(
                            text = "Or Continue with",
                            modifier = Modifier.padding(vertical = 20.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 32.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        EventoColors.secondaryVariant
                                    )
                                    .clip(EventoShaped.large)
                                    .padding(horizontal = 5.dp, vertical = 5.dp)
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.facebook),
                                    contentDescription = "Facebook login"
                                )
                            }

                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        EventoColors.secondaryVariant
                                    )
                                    .clip(EventoShaped.large)
                                    .padding(horizontal = 5.dp, vertical = 5.dp)
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.google),
                                    contentDescription = "Google login"
                                )
                            }

                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        EventoColors.secondaryVariant
                                    )
                                    .clip(EventoShaped.large)
                                    .padding(horizontal = 8.dp, vertical = 8.dp)
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.twitter),
                                    contentDescription = "Twitter login",
                                    tint = Gray
                                )
                            }
                        }
                        LinkableString(
                            modifier = Modifier.padding(top = 40.dp),
                            appendString = "Not a member?  ",
                            pushString = "Sign Up",
                            appendColor = EventoColors.onPrimary,
                            clickableTextColor = EventoColors.onPrimary,
                            onClick = toSignUp
                        )
                    }
                }
            }
        }
    }
}

