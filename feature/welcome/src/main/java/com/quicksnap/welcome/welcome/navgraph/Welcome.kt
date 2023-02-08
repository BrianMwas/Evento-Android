package com.quicksnap.welcome.welcome.navgraph

sealed class Welcome (val route: String) {
    object OnBoarding: Welcome("on_boarding")
    object Start: Welcome("start")

    object Login: Welcome("login")

    object SignUp: Welcome("signup")
}