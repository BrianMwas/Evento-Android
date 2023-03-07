package com.quicksnap.welcome.welcome.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quicksnap.welcome.welcome.authentication.login.LoginScreen
import com.quicksnap.welcome.welcome.authentication.signup.SignUpScreen
import com.quicksnap.welcome.welcome.onboarding.OnBoardingScreen
import com.quicksnap.welcome.welcome.start.StartScreen

@Composable
fun WelcomeNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Welcome.OnBoarding.route) {
        composable(route = Welcome.OnBoarding.route) {
            OnBoardingScreen(
                toWelcomeScreen = {
                    navController.navigate(Welcome.Start.route)
                }
            )
        }
        composable(route = Welcome.Start.route) {
            StartScreen(toLogin = {
                navController.navigate(Welcome.Login.route) {
                    popUpTo(Welcome.Start.route) {
                        inclusive = true
                    }
                }

            }, toSignUp = {
                navController.navigate(Welcome.SignUp.route) {
                    popUpTo(Welcome.Start.route) {
                        inclusive = true
                    }
                }

            })
        }

        composable(route = Welcome.Login.route) {
            LoginScreen( toSignUp = {
                navController.navigate(Welcome.SignUp.route) {
                    popUpTo(Welcome.Login.route)
                }
            })
        }

        composable(route = Welcome.SignUp.route) {
            SignUpScreen(
                toLogin = {
                    navController.navigate(Welcome.Login.route){
                        popUpTo(Welcome.SignUp.route)
                    }
                }
            )
        }
    }
}