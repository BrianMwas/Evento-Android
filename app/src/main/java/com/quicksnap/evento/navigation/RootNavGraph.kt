package com.quicksnap.evento.navigation

import com.quicksnap.events.presentation.EventsNavGraph
import com.quicksnap.home.presentation.HomeNavGraph
import com.quicksnap.profile.presentation.pages.ProfileNavGraph
import com.quicksnap.tickets.presentation.TicketsNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object RootNavGraph: NavGraphSpec {
    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
    override val route: String = "root"
    override val startRoute: Route = HomeNavGraph
    override val nestedNavGraphs = listOf(
        HomeNavGraph,
        EventsNavGraph,
        TicketsNavGraph,
        ProfileNavGraph
    )
}