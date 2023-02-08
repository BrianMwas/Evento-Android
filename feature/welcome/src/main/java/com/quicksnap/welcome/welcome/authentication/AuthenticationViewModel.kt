package com.quicksnap.welcome.welcome.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

sealed class AuthenticationEvent {
    object ToggleAuthenticationMode: AuthenticationEvent()
    class UsernameChanged(val username: String): AuthenticationEvent()
    class EmailChanged(val emailAddress: String): AuthenticationEvent()
    class PasswordChanged(val password: String): AuthenticationEvent()
    class ShowPasswordToggled(val show: Boolean): AuthenticationEvent()
    object Authenticate: AuthenticationEvent()
    object ErrorDismissed: AuthenticationEvent()
}

class AuthenticationViewModel @Inject constructor(): ViewModel() {
    private val _authState = MutableStateFlow(AuthenticationState())
    val authState: StateFlow<AuthenticationState> get() = _authState

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when(authenticationEvent) {
            AuthenticationEvent.ToggleAuthenticationMode -> {
                toggleAuthenticationMode()
            }
            is AuthenticationEvent.EmailChanged -> {
                updateEmail(authenticationEvent.emailAddress)
            }
            is AuthenticationEvent.PasswordChanged -> {
                updatePassword(authenticationEvent.password)
            }
            is AuthenticationEvent.ShowPasswordToggled -> {
                toggleShowPassword()
            }
            is AuthenticationEvent.UsernameChanged -> {
                updateUsername(authenticationEvent.username)
            }
            AuthenticationEvent.Authenticate -> {
                authenticate()
            }
            AuthenticationEvent.ErrorDismissed -> TODO()
        }
    }

    private fun toggleAuthenticationMode() {
        val currentMode = authState.value.authenticationMode
        val newAuthenticationMode = if (currentMode == AuthenticationMode.LOGIN) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.LOGIN
        }

        _authState.value = _authState.value.copy(
            authenticationMode = newAuthenticationMode
        )
    }

    private fun updateEmail(email: String) {
        _authState.value = _authState.value.copy(
            email = email,
        )
    }

    private fun updateUsername(username: String) {
        _authState.value = _authState.value.copy(
            username = username
        )
    }

    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()
        if (password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (password.matches(Regex("^\\w+$"))) {
            requirements.add(PasswordRequirements.ALPHANUMERIC)
        }
        _authState.value = _authState.value.copy(
            password = password,
            passwordRequirements = requirements.toList()
        )
    }

    private fun toggleShowPassword() {
        val currentShow = authState.value.showPassword
        _authState.value = _authState.value.copy(
            showPassword = !currentShow
        )
    }

    private fun authenticate() {
        _authState.value = _authState.value.copy(
            isLoading = true
        )


        val currentMode = _authState.value.authenticationMode
        if (currentMode == AuthenticationMode.LOGIN) {
            login()
        } else {
            signup()
        }
    }


    private fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            withContext(Dispatchers.Main) {
                _authState.value = _authState.value.copy(
                    isLoading = true,
                    error = "Something went wrong"
                )
            }
        }
    }

    private fun signup() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            withContext(Dispatchers.Main) {
                _authState.value = _authState.value.copy(
                    isLoading = true,
                    error = "Something went wrong"
                )
            }
        }
    }

    private fun dismissError() {
        _authState.value = _authState.value.copy(
            error = null
        )
    }
}