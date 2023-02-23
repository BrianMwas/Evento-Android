package com.quicksnap.provider

interface NavigationProvider {
    fun openEventDetail(eventId: String)
    fun openOrderDetail(eventId: String, orderId: String)
    fun openTicketDetail(ticketId: String)
    fun openFavorites()
    fun openNotifications()
    fun openChangePassword()
    fun openChangeProfileData()
    fun navigateUp()
}