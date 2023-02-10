package com.quicksnap.welcome.welcome.authentication.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.quicksnap.eventoframework.ui.EventoTextField
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.theme.*
import com.quicksnap.welcome.R
import com.quicksnap.welcome.welcome.authentication.AuthenticationEvent
import com.quicksnap.welcome.welcome.authentication.AuthenticationState

@Composable
fun LoginForm(
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit,
    forgotPassword: () -> Unit,
) {
    var isPasswordHidden by remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.padding(horizontal = 32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        EventoTextField(
            modifier = Modifier
                .clip(EventoShaped.small)
                .background(EventoColors.secondaryVariant)
                .height(48.dp),
            value = authenticationState.email ?: "",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            onChange = {
                handleEvent(AuthenticationEvent.EmailChanged(it))
            },
            placeholder = "Email", placeholderStyle = EventoTypography.body1.copy(
                Gray
            ),
            paddingStart = 27.dp,
            textStyle = EventoTypography.body1,
            cursorColor = EventoTypography.body1.color
        )
        Spacer(modifier = Modifier.height(20.dp))
        EventoTextField(
            modifier = Modifier
                .clip(EventoShaped.small)
                .background(EventoColors.secondaryVariant)
                .height(48.dp),
            value = authenticationState.password ?: "",
            onChange = {
                handleEvent(AuthenticationEvent.PasswordChanged(it))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            placeholder = "Password",
            placeholderStyle = EventoTypography.body1.copy(
                Gray
            ),
            paddingStart = 27.dp,
            textStyle = EventoTypography.body1,
            cursorColor = EventoTypography.body1.color,
            suffix = {
                IconButton(onClick = {
                    isPasswordHidden = !isPasswordHidden
                }) {
                    if (isPasswordHidden) {
                        Icon(Icons.Outlined.Visibility, contentDescription = stringResource(R.string.show_password), tint = Gray)
                    } else {
                        Icon(Icons.Outlined.VisibilityOff, contentDescription = stringResource(R.string.hide_password), tint = Gray)
                    }
                }
            },
            visualTransformation = if (isPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Forgot password?", textAlign = TextAlign.Center, modifier = Modifier.clickable {
            forgotPassword()
        })
        Spacer(modifier = Modifier.height(20.dp))
        ExpandedButton(
            background = Primary,
            onClick = {
                handleEvent(AuthenticationEvent.Authenticate)
            },
            shape = EventoShaped.small,
        ) {
            if (authenticationState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(25.dp),
                    color = White,
                    strokeCap = StrokeCap.Round,
                    strokeWidth = 2.5.dp
                )
            } else {
                Text(text = "Login",
                    style = EventoTypography.body1.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}