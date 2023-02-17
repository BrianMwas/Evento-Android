package com.quicksnap.authentication

import com.quicksnap.authentication.destinations.*
import com.ramcosta.composedestinations.spec.*

public object AuthenticationNavGraph : NavGraphSpec {
    
    override val route: String = "authentication"
    
    override val startRoute: Route = SignUpScreenDestination
    
    override val destinationsByRoute: Map<String, DestinationSpec<*>> = listOf(
		ForgotPasswordScreenDestination,
		SignInDestination,
		SignUpScreenDestination
    ).associateBy { it.route }

}
