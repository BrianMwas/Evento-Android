package com.quicksnap.welcome.welcome.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quicksnap.welcome.welcome.onboarding.OnBoardingScreen
import com.quicksnap.welcome.welcome.start.StartScreen

@Composable
fun WelcomeNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WelcomeScreen.OnBoarding.route) {
        composable(route = WelcomeScreen.OnBoarding.route) {
            OnBoardingScreen()
        }
        composable(route = WelcomeScreen.Start.route) {
            StartScreen()
        }
    }
}