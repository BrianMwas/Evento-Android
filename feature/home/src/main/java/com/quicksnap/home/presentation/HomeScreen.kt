package com.quicksnap.home.presentation


import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.quicksnap.events.presentation.list.EventsScreen
import com.quicksnap.home.components.BottomBar
import com.quicksnap.home.components.BottomBarDestinations
import com.quicksnap.profile.presentation.ProfileScreen
import com.quicksnap.provider.NavigationProvider
import com.quicksnap.tickets.presentation.TicketListScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navigator: NavigationProvider) {
    val scaffoldState = rememberScaffoldState()

    val (currentBottomTab, selectBottomTab) = rememberSaveable {
        mutableStateOf(BottomBarDestinations.Events)
    }
    
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )
    // A surface container using the 'background' color from the theme
    Crossfade(currentBottomTab) { bottomBar ->
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {
                BottomBar(
                    bottomBar,
                    selectBottomTab
                )
            },
            content = {
                val modifier = Modifier.padding(it)
                when(bottomBar) {
                    BottomBarDestinations.Events -> EventsScreen(
                        navigationProvider = navigator,
                        modifier = modifier,
                        bottomSheetState = bottomSheetState,
                    )
                    BottomBarDestinations.Tickets -> TicketListScreen(
                        navigationProvider = navigator,
                        modifier = modifier,
                        bottomSheetState = bottomSheetState
                    )
                    BottomBarDestinations.HelpCenter -> HelpdeskScreen(
                        modifier = modifier,
                    )
                    BottomBarDestinations.Profile -> ProfileScreen(
                        navigationProvider = navigator,
                        modifier = modifier,
                    )
                }
            }
        )
    }
}