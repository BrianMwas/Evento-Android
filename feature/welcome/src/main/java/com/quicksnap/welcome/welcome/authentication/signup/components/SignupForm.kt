package com.quicksnap.welcome.welcome.authentication.signup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.quicksnap.eventoframework.ui.EventoTextField
import com.quicksnap.eventoframework.ui.ExpandedButton
import com.quicksnap.theme.*
import com.quicksnap.welcome.R
import com.quicksnap.welcome.welcome.authentication.AuthenticationEvent
import com.quicksnap.welcome.welcome.authentication.AuthenticationMode
import com.quicksnap.welcome.welcome.authentication.AuthenticationState

@Composable
fun SignupForm(
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit
) {
    var isPasswordHidden by remember {
        mutableStateOf(true)
    }

    Column(modifier = Modifier.padding(horizontal = 32.dp)) {
        EventoTextField(
            modifier = Modifier
                .clip(EventoShaped.small)
                .background(EventoColors.secondaryVariant)
                .height(48.dp),
            value = authenticationState.username ?: "",
            onChange = {
                handleEvent(AuthenticationEvent.UsernameChanged(it))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            paddingStart = 8.dp,
            placeholder = "Username",
            placeholderStyle = EventoTypography.body1.copy(
                Gray
            ),
            prefix = {
                     Icon(Icons.Default.Person, contentDescription = "Username", tint = Gray, modifier = Modifier.padding(start = 8.dp))
            },
            textStyle = EventoTypography.body1,
            cursorColor = EventoTypography.body1.color
        )
        Spacer(modifier = Modifier.height(20.dp))
        EventoTextField(
            modifier = Modifier
                .clip(EventoShaped.small)
                .background(EventoColors.secondaryVariant)
                .height(48.dp),
            value = authenticationState.email ?: "",
            onChange = {
                handleEvent(AuthenticationEvent.EmailChanged(it))
            },
            paddingStart = 8.dp,
            placeholder = "Email Address",
            placeholderStyle = EventoTypography.body1.copy(
                Gray
            ),
            prefix = {
                Icon(Icons.Default.Mail, contentDescription = "Username", tint = Gray, modifier = Modifier.padding(start = 8.dp))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
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
            prefix = {
                Icon(Icons.Default.Lock, contentDescription = "Username", tint = Gray, modifier = Modifier.padding(start = 8.dp))
            },
            paddingStart = 8.dp,
            placeholder = "Password",
            placeholderStyle = EventoTypography.body1.copy(
                Gray
            ),
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
            visualTransformation = if(isPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None
        )
        Spacer(modifier = Modifier.height(30.dp))
        ExpandedButton(
            background = Primary,
            shape = EventoShaped.small,
            onClick = {
                handleEvent(AuthenticationEvent.Authenticate)
            }) {
            if (authenticationState.isLoading && authenticationState.authenticationMode == AuthenticationMode.SIGN_UP) {
                CircularProgressIndicator(
                    modifier = Modifier.size(25.dp),
                    color = White,
                    strokeCap = StrokeCap.Round,
                    strokeWidth = 2.5.dp
                )
            } else {
                Text(text = "Sign Up",
                    style = EventoTypography.body1.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}