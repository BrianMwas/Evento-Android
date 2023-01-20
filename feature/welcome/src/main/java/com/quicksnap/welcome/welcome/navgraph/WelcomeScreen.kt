package com.quicksnap.welcome.welcome.navgraph

sealed class WelcomeScreen (val route: String) {
    object OnBoarding: WelcomeScreen("on_boarding")
    object Start: WelcomeScreen("start")
}