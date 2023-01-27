package com.quicksnap.provider

interface NavigationProvider {
    fun openEventDetail(eventId: String)
    fun openOrderDetail(orderId: String)
    fun openWelcome()
    fun openSignUp()
    fun openSignIn()
    fun openForgotPassword()
    fun openNotifications()
    fun openChangePassword()
    fun navigateUp()
}