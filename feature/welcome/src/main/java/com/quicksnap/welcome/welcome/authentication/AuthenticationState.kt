package com.quicksnap.welcome.welcome.authentication

import androidx.annotation.StringRes
import com.quicksnap.welcome.R

enum class PasswordRequirements(
    @StringRes val label: Int
) {
    ALPHANUMERIC(R.string.require_alphanumeric),
    EIGHT_CHARACTERS(R.string.require_eight_characters)
}

enum class AuthenticationMode {
    LOGIN,
    SIGN_UP
}

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.LOGIN,
    val email: String? = null,
    val username: String? = null,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    val showPassword: Boolean = false,
    val error : String? = null,
    val isLoading: Boolean = false,
) {
    fun isFormValid(): Boolean {
        return password?.isNotEmpty() == true &&
                email?.isNotEmpty() == true &&
                (authenticationMode == AuthenticationMode.LOGIN || passwordRequirements.containsAll(PasswordRequirements.values().toList()))
    }
}
