package com.quicksnap.evento.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.quicksnap.evento.provider.AppNavigationProvider
import com.quicksnap.eventoframework.SetupSystemUIController
import com.quicksnap.provider.shouldUseDarkMode
import com.quicksnap.theme.EventoTheme
import com.quicksnap.theme.Primary
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency

@Composable
fun MainRoot(
    viewModel: MainViewModel = hiltViewModel(),
    finish: () -> Unit
) {
    val navController = rememberNavController()
    val isDarkMode = viewModel.themeProvider().shouldUseDarkMode()
    val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()

    val destination = currentBackStackEntryAsState?.destination?.route ?: RootNavGraph.startRoute.route
    if (destination == RootNavGraph.startRoute.route) {
        BackHandler {
            finish()
        }
    }

    EventoTheme(darkTheme = isDarkMode) {
        SetupSystemUIController(systemUiController = rememberSystemUiController(), systemColor = Primary)
        Surface(modifier = Modifier.fillMaxSize()) {
            DestinationsNavHost(
                navController = navController,
                navGraph = RootNavGraph,
                dependenciesContainerBuilder = {
                    dependency(AppNavigationProvider(navController))
                }
            )
        }
    }
}