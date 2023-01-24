package com.quicksnap.evento.navigation

import com.quicksnap.authentication.navgraph.AuthNavGraph
import com.quicksnap.authentication.signup.SignUpScreen
import com.quicksnap.home.presentation.HomeNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object RootNavGraph: NavGraphSpec {
    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
    override val route: String = "root"
    override val startRoute: Route = HomeNavGraph
    override val nestedNavGraphs = listOf(
        HomeNavGraph,
    )
}