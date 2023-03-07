package com.quicksnap.evento.provider

import androidx.navigation.NavController
import com.quicksnap.events.presentation.destinations.EventDetailsScreenDestination
import com.quicksnap.events.presentation.destinations.OrderDetailScreenDestination
import com.quicksnap.home.presentation.destinations.NotificationScreenDestination
import com.quicksnap.profile.presentation.pages.destinations.ChangePasswordScreenDestination
import com.quicksnap.profile.presentation.pages.destinations.ChangeProfileDataScreenDestination
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.tickets.presentation.destinations.TicketDetailScreenDestination
import com.ramcosta.composedestinations.navigation.navigate

class AppNavigationProvider constructor(
    private val navController: NavController
) : NavigationProvider {
    override fun openEventDetail(eventId: String) {
        navController.navigate(EventDetailsScreenDestination(eventId))
    }

    override fun openOrderDetail(eventId: String, orderId: String) {
        navController.navigate(OrderDetailScreenDestination(eventId = eventId, orderId = orderId))
    }

    override fun openTicketDetail(ticketId: String) {
        navController.navigate(TicketDetailScreenDestination(ticketId = ticketId))
    }

    override fun openFavorites() {
        TODO("Not yet implemented")
    }

    override fun openNotifications() {
        navController.navigate(NotificationScreenDestination())
    }

    override fun openChangePassword() {
        navController.navigate(ChangePasswordScreenDestination())
    }

    override fun openChangeProfileData() {
        navController.navigate(ChangeProfileDataScreenDestination())
    }

    override fun popTillParent() {
        navController.popBackStack(EventDetailsScreenDestination.route, inclusive = false)
        navigateUp()
    }

    override fun navigateUp() {
        navController.navigateUp()
    }
}