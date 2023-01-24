package com.quicksnap.evento.provider

import androidx.navigation.NavController
import com.quicksnap.provider.NavigationProvider

class AppNavigationProvider constructor(
    private val navController: NavController
) : NavigationProvider {
    override fun openEventDetail(eventId: String) {
        TODO("Not yet implemented")
    }

    override fun openOrderDetail(orderId: String) {
        TODO("Not yet implemented")
    }

    override fun openWelcome() {
        TODO("Not yet implemented")
    }

    override fun openSignUp() {
        TODO("Not yet implemented")
    }

    override fun openSignIn() {
        TODO("Not yet implemented")
    }

    override fun openForgotPassword() {
        TODO("Not yet implemented")
    }

    override fun openNotifications() {
        TODO("Not yet implemented")
    }

    override fun openChangePassword() {
        TODO("Not yet implemented")
    }

    override fun navigateUp() {
        TODO("Not yet implemented")
    }
}