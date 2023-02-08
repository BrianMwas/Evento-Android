package com.quicksnap.welcome.welcome.authentication

data class LoginAuthState(
    val email: String = "",
    val password: String = "",
    val showPassword: Boolean = false
)
